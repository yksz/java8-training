package ch03.ex12;

import java.util.function.UnaryOperator;

import javafx.scene.paint.Color;

@FunctionalInterface
public interface ColorTransformer {

    Color apply(int x, int y, Color colorAtXY);

    static ColorTransformer convert(UnaryOperator<Color> f) {
        return (x, y, colorAtXY) -> f.apply(colorAtXY);
    }

}
