package ch03.ex14;

import javafx.scene.image.PixelReader;
import javafx.scene.paint.Color;

@FunctionalInterface
public interface PixelTransformer {
    Color apply(int x, int y, PixelReader reader);
}
