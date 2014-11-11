package ch03.ex11;

import java.util.function.UnaryOperator;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;

@FunctionalInterface
public interface ColorTransformer {

    Color apply(int x, int y, Color colorAtXY);

    static ColorTransformer compose(ColorTransformer f, ColorTransformer g) {
        return (x, y, colorAtXY) -> f.apply(x, y, g.apply(x, y, colorAtXY));
    }

    static ColorTransformer convert(UnaryOperator<Color> f) {
        return (x, y, colorAtXY) -> f.apply(colorAtXY);
    }

    static ColorTransformer sash(Image img, int frameSize, Color color) {
        return (x, y, colorAtXY) -> {
            if (x <= frameSize || x >= img.getWidth() - frameSize
                    || y <= frameSize || y >= img.getHeight() - frameSize)
                return color;
            else
                return colorAtXY;
        };
    }

}
