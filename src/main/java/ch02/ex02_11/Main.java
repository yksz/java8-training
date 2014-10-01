package ch02.ex02_11;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {

    static <T> ArrayList<T> inject(Stream<T> stream, int size) {
        ArrayList<T> list = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            list.add(null);
        }
        AtomicInteger index = new AtomicInteger(0);
        stream.map(e -> new IndexedObject<>(index.getAndIncrement(), e))
                .forEach(e -> list.set(e.index, e.value));
        return list;
    }

    private static class IndexedObject<T> {
        private final int index;
        private final T value;

        public IndexedObject(int index, T value) {
            this.index = index;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Stream<Integer> s = IntStream.range(1, 10).boxed().parallel();
        List<Integer> result = inject(s, 9);

        Integer[] expected = new Integer[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        Collections.sort(result);
        assert Arrays.equals(expected, result.toArray());
    }

}
