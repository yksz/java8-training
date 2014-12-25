package ch03.ex17;

import java.util.function.Consumer;

public class LambdaUtils {

    public static <T> void doInParallelAsync(Runnable first, Runnable second, Consumer<Throwable> handler) {
        new Thread(() -> {
            try {
                first.run();
            } catch (Throwable t) {
                handler.accept(t);
            }
        }).start();
        new Thread(() -> {
            try {
                second.run();
            } catch (Throwable t) {
                handler.accept(t);
            }
        }).start();
    }

}
