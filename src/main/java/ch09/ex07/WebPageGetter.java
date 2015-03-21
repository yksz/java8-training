package ch09.ex07;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class WebPageGetter {

    public static void main(String[] args) throws IOException {
        if (args.length < 2) {
            System.out.println("usage: java WebPageGetter <url> <file>");
            System.exit(1);
        }
        URL url = new URL(args[0]);
        Path path = Paths.get(args[1]);
        try (InputStream in = url.openStream()) {
            Files.copy(in, path);
        }
    }

}
