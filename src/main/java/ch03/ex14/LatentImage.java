package ch03.ex14;

import java.util.LinkedList;
import java.util.List;

import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class LatentImage {

    private Image in;
    private List<PixelTransformer> pendingOperations;

    public static LatentImage from(Image in) {
        return new LatentImage(in);
    }

    private LatentImage(Image in) {
        this.in = in;
        pendingOperations = new LinkedList<>();
    }

    public LatentImage transform(PixelTransformer f) {
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
                for (PixelTransformer f : pendingOperations)
                    c = f.apply(x, y, in.getPixelReader());
                out.getPixelWriter().setColor(x, y, c);
            }
        }
        return out;
    }

}
