package ch02.ex02_01;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {

    static int count(List<String> words, int len) throws InterruptedException {
        int threadNum = 2;
        AtomicInteger count = new AtomicInteger(0);
        CountDownLatch latch = new CountDownLatch(threadNum);
        int n = words.size() / threadNum;
        for (int i = 0; i < words.size(); i += n) {
            int to = i + n;
            int nextTo = to + n;
            if (nextTo > words.size())
                to = words.size();
            List<String> subList = words.subList(i, to);
            count(subList, len, count, latch);
        }
        latch.await();
        return count.get();
    }

    static void count(List<String> words, int len, AtomicInteger result, CountDownLatch latch) {
        new Thread(() -> {
            int count = 0;
            for (String w : words) {
                if (w.length() > len)
                    count++;
            }
            result.addAndGet(count);
            latch.countDown();
        }).start();
    }

    public static void main(String[] args) throws InterruptedException {
        String contents = "Dynamic Host Configuration Protocol";
        List<String> words = Arrays.asList(contents.split("[^\\p{L}]+"));
        assert count(words, 12) == 1;
    }

}
