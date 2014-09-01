package ch02.ex02_08;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.Spliterators;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class Main {

    static <T> Stream<T> zip(Stream<T> first, Stream<T> second) {
        Iterator<T> iterator = new ZipIterator<>(first.iterator(), second.iterator());
        Spliterator<T> spliterator = Spliterators.spliteratorUnknownSize(iterator, Spliterator.ORDERED);
        return StreamSupport.stream(spliterator, false);
    }

    static class ZipIterator<T> implements Iterator<T> {
        private final Iterator<T> first;
        private final Iterator<T> second;
        private boolean isFirstsTurn = true;

        public ZipIterator(Iterator<T> first, Iterator<T> second) {
            this.first = first;
            this.second = second;
        }

        @Override
        public boolean hasNext() {
            return first.hasNext() && second.hasNext();
        }

        @Override
        public T next() {
            if (isFirstsTurn) {
                isFirstsTurn = false;
                return first.next();
            } else {
                isFirstsTurn = true;
                return second.next();
            }
        }
    }

    public static void main(String[] args) {
        Stream<Integer> s1 = Stream.of(1, 2, 3);
        Stream<Integer> s2 = Stream.of(4, 5, 6);
        zip(s1, s2).forEach(System.out::println); // => 1 4 2 5 3
    }

}
