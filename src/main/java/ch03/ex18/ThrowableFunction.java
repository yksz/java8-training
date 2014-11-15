package ch03.ex18;

import java.util.function.Function;

@FunctionalInterface
public interface ThrowableFunction<T, R> {

    R apply(T t) throws Exception;

    static <T, R> Function<T, R> unchecked(ThrowableFunction<T, R> f) {
        return (arg) -> {
            try {
                return f.apply(arg);
            } catch (Exception e) {
                throw new RuntimeException(e);
            } catch(Throwable t) {
                throw t;
            }
        };
    }

}
