package ch03.ex24;

import java.util.function.Function;

public class LambdaUtils {

    // できない
    // Function<T, Pair<U>> の引数に Pair<T> の1つの要素しか渡せないため
    public static <T, U> Pair<U> map(Pair<T> pair, Function<T, Pair<U>> f) {
        return f.apply(pair.getFirst());
    }

}
