package ch01.ex01_05;

public class Before {

    public static void exec() {
        new Thread(
            new Runnable() {
                @Override
                public void run() {
                   long id = Thread.currentThread().getId();
                   System.out.println("Thread-" + id + " run");
                }
            }
        ).start();
    }

}
