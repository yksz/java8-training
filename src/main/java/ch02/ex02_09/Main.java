package ch02.ex02_09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Main {

    static <T> ArrayList<T> inject1(Stream<ArrayList<T>> stream) {
        Optional<ArrayList<T>> opt = stream.reduce((acc, val) -> {
            acc.addAll(val);
            return acc;
        });
        if (opt.isPresent())
            return opt.get();
        else
            return new ArrayList<>();
    }

    static <T> ArrayList<T> inject2(Stream<ArrayList<T>> stream) {
        return stream.reduce(new ArrayList<>(), (acc, val) -> {
            acc.addAll(val);
            return acc;
        });
    }

    static <T> ArrayList<T> inject3(Stream<ArrayList<T>> stream) {
        return stream.reduce(new ArrayList<>(), (acc, val) -> {
            synchronized (acc) {
                acc.addAll(val);
            }
            return acc;
        }, (obj1, obj2) -> obj1);
    }

    static List<ArrayList<Integer>> newList() {
        List<ArrayList<Integer>> list = new ArrayList<>();
        list.add(new ArrayList<>(Arrays.asList(1, 2, 3)));
        list.add(new ArrayList<>(Arrays.asList(4, 5, 6)));
        list.add(new ArrayList<>(Arrays.asList(7, 8, 9)));
        return list;
    }

    public static void main(String[] args) {
        System.out.println(">> inject1");
        inject1(newList().stream()).stream().forEach(n -> System.out.print(n + " "));
        System.out.println();

        System.out.println(">> inject2");
        inject2(newList().stream()).stream().forEach(n -> System.out.print(n + " "));
        System.out.println();

        System.out.println(">> inject3");
        inject3(newList().stream()).stream().forEach(n -> System.out.print(n + " "));
        System.out.println();

        System.out.println(">> inject3 parallel");
        inject3(newList().parallelStream()).stream().forEach(n -> System.out.print(n + " "));
        System.out.println();
    }

}
