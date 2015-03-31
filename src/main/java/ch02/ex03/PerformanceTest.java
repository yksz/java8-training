package ch02.ex03;

import java.net.URI;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class PerformanceTest {

    static URL getResource(String resource) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        return classLoader.getResource(resource);
    }

    public static void main(String[] args) throws Exception {
        URI uri = getResource("alice.txt").toURI();
        String contents = new String(Files.readAllBytes(Paths.get(uri)), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));

        {
            long start = System.nanoTime();
            long count = words.stream().filter(w -> w.length() > 12).count();
            long stop = System.nanoTime();
            System.out.println("stream: count=" + count + ", time=" + (stop - start) + "[ns]");
        }

        {
            long start = System.nanoTime();
            long count = words.parallelStream().filter(w -> w.length() > 12) .count();
            long stop = System.nanoTime();
            System.out.println("parallelStream: count=" + count + ", time=" + (stop - start) + "[ns]");

        }
    }

}
