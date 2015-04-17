package ch06.ex07;

import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.LongStream;

public class MaxKeyFinder {

    public static void main(String[] args) {
        ConcurrentHashMap<String, Long> map = new ConcurrentHashMap<>();
        LongStream.range(0, 1000).parallel().forEach(l -> map.put(String.valueOf(l), l));
        Entry<String, Long> e = map.reduceEntries(1, (e1, e2) -> e1.getValue() > e2.getValue() ? e1 : e2);
        assert e.getKey().equals("999");
    }

}
