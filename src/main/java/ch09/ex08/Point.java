package ch09.ex08;

public class Point {

    private int x;
    private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int compareTo(Point other) {
        int diff = compare(x, other.x);
        if (diff != 0)
            return diff;
        return compare(y, other.y);
    }

    private int compare(int a, int b) {
        if (a == b)
            return 0;
        else if (a < b)
            return -1;
        else
            return 1;
    }

    public static void main(String[] args) {
        Point p1 = new Point(Integer.MAX_VALUE, Integer.MAX_VALUE);
        Point p2 = new Point(-1, -1);
        assert p1.compareTo(p2) == 1;
    }

}
