package ch03.ex15;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.UnaryOperator;

import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class LatentImage {

    private Image in;
    private List<UnaryOperator<Color>> pendingOperations;

    public static LatentImage from(Image in) {
        return new LatentImage(in);
    }

    private LatentImage(Image in) {
        this.in = in;
        pendingOperations = new LinkedList<>();
    }

    public LatentImage transform(UnaryOperator<Color> f) {
        pendingOperations.add(f);
        return this;
    }

    public Image toImage() {
        int width = (int) in.getWidth();
        int height = (int) in.getHeight();
        WritableImage out = new WritableImage(width, height);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Color c = in.getPixelReader().getColor(x, y);
                for (UnaryOperator<Color> f : pendingOperations)
                    c = f.apply(c);
                out.getPixelWriter().setColor(x, y, c);
            }
        }
        return out;
    }

    public Image parallelTransform(UnaryOperator<Color> f) {
        Color[][] inPixels = toColorArray(toImage());
        int n = Runtime.getRuntime().availableProcessors();
        int height = inPixels.length;
        int width = inPixels[0].length;
        Color[][] outPixels = new Color[height][width];
        try {
            ExecutorService pool = Executors.newCachedThreadPool();
            for (int i = 0; i < n; i++) {
                int fromY = i * height / n;
                int toY = (i + 1) * height / n;
                pool.submit(() -> {
                    for (int x = 0; x < width; x++)
                        for (int y = fromY; y < toY; y++)
                            outPixels[y][x] = f.apply(inPixels[y][x]);
                });
            }
            pool.shutdown();
            pool.awaitTermination(1, TimeUnit.HOURS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return toImage(outPixels);
    }

    public Color[][] toColorArray(Image img) {
        int width = (int) img.getWidth();
        int height = (int) img.getHeight();
        Color[][] pixels = new Color[height][width];
        for (int y = 0; y < height; y++)
            for (int x = 0; x < width; x++)
                pixels[y][x] = img.getPixelReader().getColor(x, y);
        return pixels;
    }

    public Image toImage(Color[][] pixels) {
        int width = pixels[0].length;
        int height = pixels.length;
        WritableImage img = new WritableImage(width, height);
        for (int y = 0; y < height; y++)
            for (int x = 0; x < width; x++)
                img.getPixelWriter().setColor(x, y, pixels[y][x]);
        return img;
    }

}
