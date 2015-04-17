package ch09.ex06;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;

public class ReverseWriter {

    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("/usr/share/dict/words"));
        Files.write(Paths.get("/tmp/out.txt"), new Iterable<String>() {
            public Iterator<String> iterator() {
                return new Iterator<String>() {
                    public boolean hasNext() {
                        return !lines.isEmpty();
                    }
                    public String next() {
                        return lines.remove(lines.size() - 1);
                    }
                };
            }
        });
    }

}
