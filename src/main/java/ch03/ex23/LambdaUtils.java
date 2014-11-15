package ch03.ex23;

import java.util.Objects;
import java.util.function.Function;

public class LambdaUtils {

    public static <T, U> Pair<U> map(Pair<T> pair, Function<T, U> f) {
        Objects.requireNonNull(pair, "pair must not be null");
        Objects.requireNonNull(f, "f must not be null");

        U first = f.apply(pair.getFirst());
        U second = f.apply(pair.getSecond());
        return new Pair<>(first, second);
    }

}
