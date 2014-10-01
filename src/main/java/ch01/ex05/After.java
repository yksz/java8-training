package ch01.ex05;

public class After {

    public static void exec() { // 5 行短くなった
        new Thread(() -> {
            long id = Thread.currentThread().getId();
            System.out.println("Thread-" + id + " run");
        }).start();
    }

}
