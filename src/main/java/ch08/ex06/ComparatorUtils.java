package ch08.ex06;

import java.awt.Point;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.util.Arrays;
import java.util.Comparator;

public class ComparatorUtils {

    static Comparator<Point2D> comparingPoint2D() {
        return Comparator.comparing(Point2D::getX)
                .thenComparing(Point2D::getY);
    }

    static Comparator<Rectangle2D> comparingRectangle2D() {
        return Comparator.comparing(Rectangle2D::getMaxX)
                .thenComparing(Rectangle2D::getMaxY)
                .thenComparing(Rectangle2D::getMinX)
                .thenComparing(Rectangle2D::getMinY);
    }

    public static void main(String[] args) {
        Point[] expected = { new Point(0, 1), new Point(0, 1), new Point(2, 3) };
        Point[] actual = { new Point(0, 1), new Point(2, 3), new Point(0, 1) };
        Arrays.sort(actual, comparingPoint2D());
        assert Arrays.equals(expected, actual);
    }

}
