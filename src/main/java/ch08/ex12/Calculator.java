package ch08.ex12;

public class Calculator {

    @TestCase(params = { 1, 2 }, expected = 3)
    public static int add(int x, int y) {
        return x + y;
    }

    @TestCase(params = { 1, 2 }, expected = -1)
    public int sub(int x, int y) {
        return x - y;
    }

}
