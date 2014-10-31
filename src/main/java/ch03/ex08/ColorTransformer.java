package ch03.ex08;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;

@FunctionalInterface
public interface ColorTransformer {

    Color apply(int x, int y, Color colorAtXY);

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
