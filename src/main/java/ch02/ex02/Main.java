package ch02.ex02;

import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        String contents = "abcdefg abcdef abcde abcd abc ab a";
        List<String> words = Arrays.asList(contents.split(" "));
        words.stream().filter(w -> {
            System.out.println(w);
            return w.length() >= 3;
        }).limit(5).count();
    }

}
