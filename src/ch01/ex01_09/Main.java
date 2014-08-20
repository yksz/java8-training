package ch01.ex01_09;

public class Main {

    public static void main(String[] args) {
        ArrayList2<String> list = new ArrayList2<>();
        list.add("hoge");
        list.add("foo");
        list.add("bar");
        list.forEachIf(System.out::println, (str -> str.equals("foo")));
    }

}
