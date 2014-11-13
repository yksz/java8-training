package ch03.ex16;

import java.util.function.BiConsumer;
import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LambdaUtils {

    public static <T> void doInOrderAsync(Supplier<T> first, BiConsumer<T, Throwable> second) {
        Thread t = new Thread() {
            public void run() {
                try {
                    T result = first.get();
                    second.accept(result, null);
                } catch (Throwable t) {
                    second.accept(null, t);
                }
            }
        };
        t.start();
    }

    private static final Logger logger = Logger.getLogger("main");

    static class Mock {
        public void execute(long id) {
            logger.info(String.valueOf(id));
        }
    }

    public static void main(String[] args) {
        String msg = "1";
        LambdaUtils.doInOrderAsync(() -> Long.valueOf(msg), (id, t) -> {
            if (id != null) {
                new Mock().execute(id);
            } else if (t != null) {
                logger.log(Level.SEVERE, "error", t);
            }
        });
    }

}
