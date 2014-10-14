package ch03.ex03;

import java.util.function.Supplier;

// Not thread safe
public class Assertion {

    public static boolean isEnabled = false;

    public static void setEnabled(boolean b) {
        isEnabled = b;
    }

    public static void asserts(Supplier<Boolean> condition) {
        asserts(condition, () -> "");
    }


    public static void asserts(Supplier<Boolean> condition, Supplier<String> message) {
        if (!isEnabled)
            return;
        if (!condition.get())
            throw new AssertionError(message.get());
    }

}
