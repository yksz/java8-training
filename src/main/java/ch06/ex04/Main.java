package ch06.ex04;

import java.util.concurrent.atomic.LongAccumulator;
import java.util.stream.LongStream;

public class Main {

    public static void main(String[] args) {
        LongAccumulator max = new LongAccumulator(Long::max, Long.MIN_VALUE);
        LongStream.range(0, 1000).parallel().forEach(max::accumulate);
        assert max.get() == 999;

        LongAccumulator min = new LongAccumulator(Long::min, Long.MAX_VALUE);
        LongStream.range(0, 1000).parallel().forEach(min::accumulate);
        assert min.get() == 0;
    }

}
