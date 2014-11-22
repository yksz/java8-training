package ch04.ex05;

import java.util.Objects;
import java.util.function.BiFunction;
import java.util.function.Function;

import javafx.beans.InvalidationListener;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

public class BindingUtils {

    public static <T, R> ObservableValue<R> observe(Function<T, R> f,
            ObservableValue<T> t) {
        Objects.requireNonNull(f, "f must not be null");
        Objects.requireNonNull(t, "t must not be null");

        return new ObservableValue<R>() {
            @Override
            public R getValue() {
                return f.apply(t.getValue());
            }

            @Override
            public void addListener(InvalidationListener listener) {
                t.addListener(listener);
            }

            @Override
            public void removeListener(InvalidationListener listener) {
                t.removeListener(listener);
            }

            @Override
            public void addListener(ChangeListener<? super R> listener) {
            }

            @Override
            public void removeListener(ChangeListener<? super R> listener) {
            }
        };
    }

    public static <T, U, R> ObservableValue<R> observe(BiFunction<T, U, R> f,
            ObservableValue<T> t, ObservableValue<U> u) {
        Objects.requireNonNull(f, "f must not be null");
        Objects.requireNonNull(t, "t must not be null");
        Objects.requireNonNull(u, "u must not be null");

        return new ObservableValue<R>() {
            @Override
            public R getValue() {
                return f.apply(t.getValue(), u.getValue());
            }

            @Override
            public void addListener(InvalidationListener listener) {
                t.addListener(listener);
            }

            @Override
            public void removeListener(InvalidationListener listener) {
                t.removeListener(listener);
            }

            @Override
            public void addListener(ChangeListener<? super R> listener) {
            }

            @Override
            public void removeListener(ChangeListener<? super R> listener) {
            }
        };
    }

}
