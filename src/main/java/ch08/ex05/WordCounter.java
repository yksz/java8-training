package ch08.ex05;

import java.net.URI;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.function.Supplier;

public class WordCounter {

    static URL getResource(String resource) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        return classLoader.getResource(resource);
    }

    static List<String> getWords(String filename) throws Exception {
        URI uri = getResource(filename).toURI();
        String contents = new String(Files.readAllBytes(Paths.get(uri)), StandardCharsets.UTF_8);
        return new LinkedList<>(Arrays.asList(contents.split("[\\P{L}]+")));
    }

    static long countByStream(List<String> words) {
        return withClock("countByStream: ", () ->
            words.stream().filter(w -> w.length() > 12).count()
        );
    }

    static long countByCollection(List<String> words) {
        return withClock("countByCollection: ", () -> {
            words.removeIf(w -> w.length() <= 12);
            return (long) words.size();
        });
    }

    static <T> T withClock(String message, Supplier<T> func) {
        T result;
        long start = System.nanoTime();
        result = func.get();
        long stop = System.nanoTime();
        System.out.println(message + ((stop - start) * 0.00001) + "[ms]");
        return result;
    }

    public static void main(String[] args) throws Exception {
        long cnt1 = countByStream(getWords("alice.txt"));
        long cnt2 = countByCollection(getWords("alice.txt"));
        assert cnt1 == cnt2;
    }

}
