package ch01.ex01_02;

import java.io.File;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        File targetDir = new File(".");
        if (args.length > 0)
            targetDir = new File(args[0]);

        File[] dirs = targetDir.listFiles(file -> file.isDirectory());
        Arrays.stream(dirs).forEach(f -> System.out.println(f));
    }

}
