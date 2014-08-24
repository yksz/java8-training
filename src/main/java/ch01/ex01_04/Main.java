package ch01.ex01_04;

import java.io.File;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        File targetDir = new File(".");
        if (args.length > 0)
            targetDir = new File(args[0]);

        File[] files = targetDir.listFiles();
        Arrays.sort(files, (first, second) -> {
           if (first.isDirectory() && second.isFile())
               return -1;
           else if (first.isFile() && second.isDirectory())
               return 1;
           else
               return 0;
        });
        Arrays.stream(files).forEach(System.out::println);
    }

}
