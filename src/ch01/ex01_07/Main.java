package ch01.ex01_07;

public class Main {

    public static Runnable andThen(Runnable r1, Runnable r2) {
        r1.run();
        return r2;
    }

    public static void main(String[] args) {
        andThen((() -> System.out.println("first")),
                (() -> System.out.println("second")))
                .run();
    }

}
