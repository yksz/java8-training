package ch01.ex01_07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static Runnable andThen(Runnable r1, Runnable r2) {
        r1.run();
        return r2;
    }

    public static void main(String[] args) {
        List<String> result = new ArrayList<>();
        andThen((() -> result.add("first")),
                (() -> result.add("second")))
                .run();
        String[] expected = new String[] { "first", "second" };
        assert Arrays.equals(expected, result.toArray());
    }

}
