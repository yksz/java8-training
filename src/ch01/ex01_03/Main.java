package ch01.ex01_03;

import java.io.File;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws Exception {
        if (args.length < 2) {
            System.out.println("usage: <directory> <extension>");
            System.exit(1);
        }
        File targetDir = new File(args[0]);
        String targetExt = args[1]; // エンクロージングスコープからキャプチャされる変数

        String[] files = targetDir.list((dir, name) -> {
            if (new File(name).isDirectory())
                return false;
            int index = name.lastIndexOf(".");
            if (index == -1)
                return false;
            else
                return name.substring(index + 1).equals(targetExt);
        });
        Arrays.stream(files).forEach(f -> System.out.println(f));
    }

}
