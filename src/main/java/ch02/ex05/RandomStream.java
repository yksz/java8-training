package ch02.ex05;

import java.util.Arrays;
import java.util.stream.Stream;

public class RandomStream {

    static Stream<Long> randomStream(long seed) {
        long a = 25214903917L;
        int c = 11;
        long m = (long) Math.pow(2, 48);
        return Stream.iterate(seed, x -> (a * x + c) % m);
    }

    public static void main(String[] args) {
        Long[] expected = new Long[] { 0L, 11L, 277363943098L, 11718085204285L };
        assert Arrays.equals(expected, randomStream(0).limit(4).toArray());
    }

}
