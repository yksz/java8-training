package ch06.ex03;

import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;


public class PerformanceTest {

    static void exec(int threadNum, Runnable f) throws InterruptedException {
        Thread[] threads = new Thread[threadNum];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(f);
        }
        for (Thread th : threads) {
            th.start();
        }
        for (Thread th : threads) {
            th.join();
        }
    }

    public static void main(String[] args) throws Exception {
        {
            AtomicLong al = new AtomicLong(0);
            long begin = System.nanoTime();
            exec(1000, () -> {
                for (int i = 0; i < 100000; i++) {
                    al.incrementAndGet();
                }
            });
            long end = System.nanoTime();
            System.out.println("AtomicLong: sum=" + al.get() + ", time=" + (end - begin) + "[ns]");
        }

        {
            LongAdder la = new LongAdder();
            long begin = System.nanoTime();
            exec(1000, () -> {
                for (int i = 0; i < 100000; i++) {
                    la.increment();
                }
            });
            long end = System.nanoTime();
            System.out.println("LongAdder : sum=" + la.sum() + ", time=" + (end - begin) + "[ns]");
        }
    }

}
