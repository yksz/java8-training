package ch09.ex01;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Scanner;

public class TryWithResources {

    public static void main(String[] args) throws IOException {
        Scanner in = null;
        PrintWriter out = null;
        try {
            in = new Scanner(Paths.get("/usr/share/dict/words"));
            out = new PrintWriter("/tmp/out.txt");
            while (in.hasNext())
                out.println(in.next().toLowerCase());
        } finally {
            if (in != null)
                in.close();
            if (out != null)
                out.close();
        }
    }

}
