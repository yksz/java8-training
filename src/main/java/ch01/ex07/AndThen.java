package ch01.ex07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AndThen {

    public static Runnable andThen(Runnable r1, Runnable r2) {
        return () -> {
            r1.run();
            r2.run();
        };
    }

    public static void main(String[] args) throws InterruptedException {
        List<String> out = new ArrayList<>();
        Thread th = new Thread(andThen(() -> out.add("first"),
                                       () -> out.add("second")));
        th.start();
        th.join();
        String[] expected = new String[] { "first", "second" };
        assert Arrays.equals(expected, out.toArray());
    }

}
