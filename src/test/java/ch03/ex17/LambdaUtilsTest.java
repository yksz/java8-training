package ch03.ex17;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;

import org.junit.Test;

public class LambdaUtilsTest {

    @Test
    public void testDoInParallelAsync() throws InterruptedException {
        List<Long> out = Collections.synchronizedList(new ArrayList<>());

        CountDownLatch latch = new CountDownLatch(2);
        LambdaUtils.doInParallelAsync(() -> {
            out.add(Thread.currentThread().getId());
            latch.countDown();
        }, () -> {
            out.add(Thread.currentThread().getId());
            latch.countDown();
        }, (t) -> assertNull(t));
        latch.await();

        assertTrue(out.get(0) != out.get(1));
    }

    @Test
    public void testDoInParallelAsyncThrowException() throws InterruptedException {
        RuntimeException ex = new RuntimeException();

        CountDownLatch latch = new CountDownLatch(1);
        LambdaUtils.doInParallelAsync(() -> {
            throw ex;
        }, () -> {
            throw ex;
        }, (t) -> {
            assertEquals(ex, t);
            latch.countDown();
        });
        latch.await();
    }

}
