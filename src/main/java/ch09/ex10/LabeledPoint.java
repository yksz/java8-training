package ch09.ex10;

public class LabeledPoint {

    private String label;
    private int x;
    private int y;

    public LabeledPoint(String label, int x, int y) {
        this.label = label;
        this.x = x;
        this.y = y;
    }

    public int compareTo(LabeledPoint other) {
        int diff = label.compareTo(other.label);
        if (diff != 0)
            return diff;
        diff = Integer.compare(x, other.x);
        if (diff != 0)
            return diff;
        return Integer.compare(y, other.y);
    }

}
