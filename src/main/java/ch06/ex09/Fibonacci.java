package ch06.ex09;

import java.util.Arrays;

public class Fibonacci {

    private static final int[][] F = { { 1, 1 },
                                       { 1, 0 } };

    static int fibonacci(int n) {
        int[][][] array = new int[n + 1][2][2];
        Arrays.parallelSetAll(array, i -> F);
        Arrays.parallelPrefix(array, (a, b) -> Matrix.multiply(a, b));
        int[][] Fn = array[n];
        return Fn[1][1];
    }

    static int[] fibonacci(int from, int to) {
        int[] result = new int[to - from];
        for (int i = 0; i < result.length; i++)
            result[i] = fibonacci(from + i);
        return result;
    }

    public static void main(String[] args) {
        assert Arrays.equals(new int[] { 0, 1, 1, 2, 3, 5, 8, 13, 21, 34 },
                fibonacci(0, 10));
    }

}
