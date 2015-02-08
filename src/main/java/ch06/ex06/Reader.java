package ch06.ex06;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public class Reader {

    private ConcurrentMap<String, Set<File>> map = new ConcurrentHashMap<>();

    public void read(File... files) throws InterruptedException {
        List<Thread> threads = new ArrayList<>();
        for (File file : files) {
            Thread th = new Thread(() -> put(getWords(file), file));
            th.start();
            threads.add(th);
        }
        for (Thread th : threads) {
            th.join();
        }
    }

    private String[] getWords(File file) {
        try {
            String contents = new String(Files.readAllBytes(file.toPath()), StandardCharsets.UTF_8);
            return contents.split("[\\P{L}]+");
        } catch (IOException e) {
            e.printStackTrace();
            return new String[0];
        }
    }

    private void put(String[] words, File file) {
        for (String word : words) {
            map.computeIfAbsent(word, key -> {
                Set<File> set = new HashSet<>();
                set.add(file);
                return set;
            });
            map.computeIfPresent(word, (key, value) -> {
                value.add(file);
                return value;
            });
        }
    }

    static URL getResource(String resource) {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        return classLoader.getResource(resource);
    }

    public static void main(String[] args) throws Exception {
        File dir = new File(getResource("ch06/text").toURI());
        Reader reader = new Reader();
        reader.read(dir.listFiles(file -> file.getName().matches(".+txt$")));
        reader.map.forEach((key, value) -> {
            System.out.println(key + ": " + value);
        });
    }

}
