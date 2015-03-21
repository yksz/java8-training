package ch09.ex09;

import java.util.Objects;

public class LabeledPoint {

    private String label;
    private int x;
    private int y;

    public LabeledPoint(String label, int x, int y) {
        this.label = label;
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (!(obj instanceof LabeledPoint)) {
            return false;
        }
        LabeledPoint other = (LabeledPoint) obj;
        return Objects.equals(label, other.label) &&
        Objects.equals(x, other.x) &&
        Objects.equals(y, other.y);
    }

    @Override
    public int hashCode() {
        return Objects.hash(label, x, y);
    }

    public static void main(String[] args) {
        LabeledPoint p1 = new LabeledPoint("foo", 1, 1);
        LabeledPoint p2 = new LabeledPoint("foo", 1, 1);
        LabeledPoint p3 = new LabeledPoint("bar", 1, 1);
        assert p1.equals(p2);
        assert !p1.equals(p3);
        assert p1.hashCode() == p2.hashCode();
        assert p1.hashCode() != p3.hashCode();
    }

}
