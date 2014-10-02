package ch01.ex07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static Runnable andThen(Runnable r1, Runnable r2) {
        r1.run();
        return r2;
    }

    public static void main(String[] args) {
        List<String> out = new ArrayList<>();
        andThen((() -> out.add("first")),
                (() -> out.add("second")))
                .run();
        String[] expected = new String[] { "first", "second" };
        assert Arrays.equals(expected, out.toArray());
    }

}
