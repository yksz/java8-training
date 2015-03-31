package ch06.ex08;

import java.util.Arrays;
import java.util.stream.IntStream;

public class ArraysSortTest {

    // 1 -2 3 -4 ...
    static int[] newArray(int size) {
        return IntStream
                .iterate(1, n -> -1 * (int) Math.signum(n) * (Math.abs(n) + 1))
                .limit(size).toArray();
    }

    static long withClock(Runnable f) {
        long start = System.nanoTime();
        f.run();
        long stop = System.nanoTime();
        return stop - start;
    }

    static boolean isParallelSortFaster(int[] array) {
        int[] a1 = array;
        int[] a2 = array.clone();
        long t1 = withClock(() -> Arrays.sort(a1));
        long t2 = withClock(() -> Arrays.parallelSort(a2));
        return t2 < t1;
    }

    public static void main(String[] args) {
        int size = 1000000;
        System.out.println(isParallelSortFaster(newArray(size)));
    }

}
