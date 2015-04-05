package ch08.ex01;

public class Unsigned {

    static long add(int x, int y) {
        return Integer.toUnsignedLong(x + y);
    }

    static long sub(int x, int y) {
        return Integer.toUnsignedLong(x - y);
    }

    static int div(int x, int y) {
        return Integer.divideUnsigned(x, y);
    }

    static int compare(int x, int y) {
        return Integer.compareUnsigned(x, y);
    }

    public static void main(String[] args) {
        assert add(Integer.MAX_VALUE,  1) == 2147483648L;
        assert sub(Integer.MAX_VALUE, -1) == 2147483648L;
        assert div(Integer.MAX_VALUE - 1, 2) == 1073741823;
        assert compare(Integer.MAX_VALUE, 0) > 0;
    }

}
