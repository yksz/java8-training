package ch02.ex02_06;

import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    static Stream<Character> characterStream(String s) {
        return IntStream.range(0, s.length()).boxed().map(s::charAt);
    }

    public static void main(String[] args) {
        characterStream("Hello World!").forEach(System.out::println);
    }

}
