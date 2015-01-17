package ch06.ex01;

import java.util.concurrent.atomic.AtomicReference;

public class StringManager {

    private final AtomicReference<String> atomicString;

    public StringManager(String initValue) {
        if (initValue == null)
            initValue = "";
        atomicString = new AtomicReference<>(initValue);
    }

    public void updateMaxLength(String str) {
        atomicString.updateAndGet(x -> x.length() >= str.length() ? x : str);
    }

    public String getString() {
        return atomicString.get();
    }

    public static void main(String[] args) throws InterruptedException {
        StringManager manager = new StringManager(null);

        Thread[] threads = new Thread[1000];
        for (int i = 1; i <= threads.length; i++) {
            final String str = String.valueOf(i);
            threads[i - 1] = new Thread(() -> manager.updateMaxLength(str));
        }
        for (Thread th : threads) {
            th.start();
        }
        for (Thread th : threads) {
            th.join();
        }

        assert manager.getString().equals("1000");
    }

}
