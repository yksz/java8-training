package ch03.ex01;

import java.util.function.Supplier;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Loggers {

    public static void logIf(Logger logger, Level level,
            Supplier<Boolean> trigger, Supplier<String> message) {
        if (logger.isLoggable(level))
            if (trigger.get())
                logger.log(level, message.get());
    }

}
