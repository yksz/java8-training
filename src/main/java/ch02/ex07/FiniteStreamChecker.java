package ch02.ex07;

import java.util.Spliterator;
import java.util.stream.Stream;

public class FiniteStreamChecker {

    // isFinite は終端操作であるため実用的ではない
    static <T> boolean isFinite(Stream<T> stream) {
        Spliterator<T> spliterator = stream.spliterator();
        return spliterator.hasCharacteristics(Spliterator.SIZED);
    }

    public static void main(String[] args) {
        Stream<Integer> s1 = Stream.of(1, 2, 3);
        Stream<Integer> s2 = Stream.iterate(0, n -> n + 1);
        Stream<Integer> s3 = Stream.iterate(0, n -> n + 1).limit(10);
        assert isFinite(s1) == true;
        assert isFinite(s2) == false;
        assert isFinite(s3) == false;
    }

}
