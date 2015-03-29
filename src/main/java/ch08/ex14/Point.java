package ch08.ex14;

import java.util.Objects;

public class Point {

    private Integer x;
    private Integer y;

    public Point(Integer x, Integer y) {
        this.x = Objects.requireNonNull(x, "x must not be null");
        this.y = Objects.requireNonNull(y, "y must not be null");
    }

}
