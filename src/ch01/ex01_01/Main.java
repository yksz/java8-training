package ch01.ex01_01;

import java.util.Arrays;

public class Main {

    // 呼び出したスレッドで実行される
    public static void main(String[] args) {
        System.out.println("Main-Thread ID: " + Thread.currentThread().getId());
        String[] strs = {"abc", "a", "ab"};
        Arrays.sort(strs, (first, second) -> {
            System.out.println("Arrays.sort-Thread ID: " + Thread.currentThread().getId());
            return Integer.compare(first.length(), second.length());
        });
        Arrays.stream(strs).forEach(s -> System.out.println(s));
    }

}
