package ch01.ex01_01;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        long mainThreadID = Thread.currentThread().getId();
        String[] strs = {"abc", "a", "ab"};
        Arrays.sort(strs, (first, second) -> {
            assert Thread.currentThread().getId() == mainThreadID;
            return Integer.compare(first.length(), second.length());
        });
    }

}
