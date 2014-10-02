package ch03.ex02;

import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLocks {

    public static void withLock(ReentrantLock lock, Runnable action) {
        lock.lock();
        try {
            action.run();
        } finally {
            lock.unlock();
        }
    }

}
