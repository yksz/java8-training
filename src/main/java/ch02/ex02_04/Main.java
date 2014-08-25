package ch02.ex02_04;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        int[] values = { 1, 4, 9, 16 };
        Stream<int[]> s1 = Stream.of(values);
        assert s1 instanceof Stream;
        IntStream s2 = IntStream.of(values);
        assert s2 instanceof IntStream;
    }

}
