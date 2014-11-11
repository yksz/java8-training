package ch03.ex13;

import java.util.LinkedList;
import java.util.List;
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

    public Image detectEdge() {
        Image in = toImage();
        int width = (int) in.getWidth();
        int height = (int) in.getHeight();
        WritableImage out = new WritableImage(width, height);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                Color c = getEdgeColor(x, y, in);
                out.getPixelWriter().setColor(x, y, c);
            }
        }
        return out;
    }

    private Color getEdgeColor(int x, int y, Image img) {
        Color c = getColor(x, y, img);
        Color n = getColor(x, y - 1, img);
        Color e = getColor(x + 1, y, img);
        Color w = getColor(x - 1, y, img);
        Color s = getColor(x, y + 1, img);
        double red   = getEdgeComponent(c.getRed(),   n.getRed(),   e.getRed(),   w.getRed(),   s.getRed());
        double green = getEdgeComponent(c.getGreen(), n.getGreen(), e.getGreen(), w.getGreen(), s.getGreen());
        double blue  = getEdgeComponent(c.getBlue(),  n.getBlue(),  e.getBlue(),  w.getBlue(),  s.getBlue());
        red   = limit(red,   0.0, 1.0);
        green = limit(green, 0.0, 1.0);
        blue  = limit(blue,  0.0, 1.0);
        return Color.color(red, green, blue);
    }

    private Color getColor(int x, int y, Image img) {
        int width = (int) img.getWidth();
        int height = (int) img.getHeight();
        if (x < 0)
            x = 0;
        if (x >= width)
            x = width - 1;
        if (y < 0)
            y = 0;
        if (y >= height)
            y = height - 1;
        return img.getPixelReader().getColor(x, y);
    }

    private double getEdgeComponent(double c, double n, double e, double w, double s) {
        return 4 * c - n - e - s - w;
    }

    public double limit(double value, double min, double max) {
        if (value < min)
            return min;
        else if (value > max)
            return max;
        else
            return value;
    }

}
