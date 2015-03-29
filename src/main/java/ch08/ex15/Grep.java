package ch08.ex15;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Grep {

    public static void main(String[] args) throws IOException {
        if (args.length < 2) {
            System.out.println("usage: java Grep <regex> <file>");
            System.exit(1);
        }
        String regex = args[0];
        String file = args[1];
        Pattern pattern = Pattern.compile(regex);
        try (Stream<String> lines = Files.lines(Paths.get(file))) {
            lines.filter(pattern.asPredicate()).forEach(System.out::println);
        }
    }

}
