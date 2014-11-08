package ch03.ex10;

import java.util.function.UnaryOperator;

import javafx.scene.image.Image;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

public class Main {

    public static Image transform(Image in, UnaryOperator<Color> f) {
        int width = (int) in.getWidth();
        int height = (int) in.getHeight();
        WritableImage out = new WritableImage(width, height);
        for (int x = 0; x < width; x++)
            for (int y = 0; y < height; y++)
                out.getPixelWriter().setColor(x, y,
                        f.apply(in.getPixelReader().getColor(x, y)));
        return out;
    }

    // compose メソッドの戻り値が Function 型であるため
    public static void main(String[] args) {
        Image image = null;
        UnaryOperator<Color> op = Color::brighter;
        //Image finalImage = transform(image, op.compose(Color::grayscale));
    }

}
