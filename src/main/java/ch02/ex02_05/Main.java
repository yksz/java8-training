package ch02.ex02_05;

import java.util.stream.Stream;

public class Main {

    static Stream<Long> randomStream(long seed) {
        long a = 25214903917L;
        int c = 11;
        long m = (long) Math.pow(2, 48);
        return Stream.iterate(seed, x -> (a * x + c) % m);
    }

    public static void main(String[] args) {
        randomStream(0).limit(5).forEach(System.out::println);
    }

}
