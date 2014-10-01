package ch01.ex09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        ArrayList2<String> list = new ArrayList2<>();
        list.add("hoge");
        list.add("foo");
        list.add("bar");

        List<String> result = new ArrayList<>();
        list.forEachIf((s) -> result.add(s), (str -> str.equals("foo")));
        assert Arrays.equals(new String[] { "foo" }, result.toArray());
    }

}
