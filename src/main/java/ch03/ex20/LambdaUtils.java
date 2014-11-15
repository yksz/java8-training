package ch03.ex20;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;

public class LambdaUtils {

    public static <T, U> List<U> map(List<T> items, Function<T, U> f) {
        Objects.requireNonNull(items, "items must not be null");
        Objects.requireNonNull(f, "f must not be null");

        List<U> list = new ArrayList<>(items.size());
        for (T item : items) {
            list.add(f.apply(item));
        }
        return list;
    }

}
