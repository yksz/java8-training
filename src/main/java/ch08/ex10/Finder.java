package ch08.ex10;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Finder {

    public static void main(String[] args) throws IOException {
        if (args.length < 2) {
            System.out.println("usage: java Finder <directory> <words>");
            System.exit(1);
        }
        String root = args[0];
        List<String> words = new ArrayList<>();
        for (int i = 1; i < args.length; i++) {
            words.add(args[i]);
        }

        try (Stream<Path> entries = Files.walk(Paths.get(root))) {
            Stream<Path> files = entries.filter(path -> path.toFile().isFile());
            files.forEach(path -> {
                try (Stream<String> lines = Files.lines(path)) {
                    Stream<String> filteredLines = lines;
                    for (String word : words) {
                        filteredLines = filteredLines.filter(line -> line.contains(word));
                    }
                    Optional<String> entry = filteredLines.findFirst();
                    if (entry.isPresent()) {
                        System.out.println(path);
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        }
    }

}
