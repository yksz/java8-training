package ch02.ex13;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

import java.net.URI;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.stream.Stream;

public class WordCounter {

    static URL getResource(String resource) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        return classLoader.getResource(resource);
    }

    public static void main(String[] args) throws Exception {
        URI uri = getResource("alice.txt").toURI();
        String contents = new String(Files.readAllBytes(Paths.get(uri)), StandardCharsets.UTF_8);
        String[] wordArray = contents.split("[\\P{L}]+");
        Stream<String> words = Stream.of(wordArray).parallel();

        Map<Integer, Long> countByLength = words.parallel()
                .filter(s -> s.length() < 12)
                .collect(groupingBy(String::length, counting()));
        countByLength.forEach((k, v) -> System.out.println(k + ": " + v));
    }

}
