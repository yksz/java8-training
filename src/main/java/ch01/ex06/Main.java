package ch01.ex06;

import java.util.concurrent.Callable;

public class Main {

    public static Runnable uncheck(RunnableEx runner) {
        return () -> {
            try {
                runner.run();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
    }

    public static Runnable uncheckByCallable(Callable<Void> callable) {
        return () -> {
            try {
                callable.call();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        };
    }

    public static void main(String[] args) {
        new Thread(uncheck(() -> {
            System.out.println("Zzz");
            Thread.sleep(1000);
        })).start();

        new Thread(uncheckByCallable(() -> {
            System.out.println("Zzz");
            Thread.sleep(1000);
            return null;
        })).start();
    }

}
