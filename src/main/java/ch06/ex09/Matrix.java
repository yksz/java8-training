package ch06.ex09;

import java.util.Arrays;

class Matrix {

    public static int[][] multiply(int[][] a, int[][] b) {
        int n = a.length;
        int[][] c = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                for (int k = 0; k < n; k++)
                    c[i][j] += a[i][k] * b[k][j];
        return c;
    }

    public static void main(String[] args) {
        int[][] a = { { 1, 2, 3 },
                      { 4, 5, 6 },
                      { 7, 8, 9 } };
        int[][] b = { { 1, 0, 0 },
                      { 0, 1, 0 },
                      { 0, 0, 1 } };
        int[][] c = multiply(a, b);
        for (int i = 0; i < c.length; i++)
            assert Arrays.equals(a[i], c[i]);
    }

}
