package ch09.ex05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    static byte[] reverse(byte[] src) {
        byte[] dst = new byte[src.length];
        for (int i = 0; i < src.length; i++) {
            dst[src.length - 1 - i] = src[i];
        }
        return dst;
    }

    public static void main(String[] args) throws IOException {
        byte[] bytes = Files.readAllBytes(Paths.get("/usr/share/dict/words"));
        Files.write(Paths.get("/tmp/out.txt"), reverse(bytes));
    }

}
