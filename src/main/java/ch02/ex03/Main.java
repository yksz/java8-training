package ch02.ex03;

import java.net.URI;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class Main {

    static URL getResource(String resource) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        return classLoader.getResource(resource);
    }

    public static void main(String[] args) throws Exception {
        URI uri = getResource("ch02/alice.txt").toURI();
        String contents = new String(Files.readAllBytes(Paths.get(uri)), StandardCharsets.UTF_8);
        List<String> words = Arrays.asList(contents.split("[\\P{L}]+"));

        long begin1 = System.nanoTime();
        long count1 = words.stream().filter(w -> w.length() > 12).count();
        long end1 = System.nanoTime();
        System.out.println("stream: count=" + count1 + ", time="+ (end1 - begin1) + "[ns]");

        long begin2 = System.nanoTime();
        long count2 = words.parallelStream().filter(w -> w.length() > 12).count();
        long end2 = System.nanoTime();
        System.out.println("parallelStream: count=" + count2 + ", time="+ (end2 - begin2) + "[ns]");
    }

}
