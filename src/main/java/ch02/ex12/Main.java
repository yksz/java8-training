package ch02.ex12;

import java.net.URI;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class Main {

    static URL getResource(String resource) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        return classLoader.getResource(resource);
    }

    public static void main(String[] args) throws Exception {
        URI uri = getResource("ch02/alice.txt").toURI();
        String contents = new String(Files.readAllBytes(Paths.get(uri)), StandardCharsets.UTF_8);
        String[] wordArray = contents.split("[\\P{L}]+");
        Stream<String> words = Stream.of(wordArray).parallel();

        AtomicInteger[] shortWords = new AtomicInteger[12];
        for (int i = 0; i < shortWords.length; i++) {
            shortWords[i] = new AtomicInteger(0);
        }
        words.parallel().forEach(s -> {
            if (s.length() < 12)
                shortWords[s.length()].getAndIncrement();
        });
        System.out.println(Arrays.toString(shortWords));
    }

}
