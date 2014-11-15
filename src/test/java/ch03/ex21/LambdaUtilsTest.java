package ch03.ex21;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

import org.junit.Test;

public class LambdaUtilsTest {

    @Test
    public void testMap() throws InterruptedException, ExecutionException {
        // setup:
        List<String> out = new ArrayList<>();
        ExecutorService executor = Executors.newSingleThreadExecutor();
        CountDownLatch latch = new CountDownLatch(1);

        // when:
        Future<String> future1 = executor.submit(() -> {
            latch.await();
            out.add("task");
            return "1";
        });
        Future<Integer> future2 = LambdaUtils.map(future1, Integer::valueOf);

        // then:
        assertEquals(0, out.size());

        // when:
        latch.countDown();

        // then:
        assertEquals((Integer) 1, future2.get());
        assertEquals(1, out.size());
    }

    @Test(expected=NullPointerException.class)
    public void testMapFutureIsNull() {
        LambdaUtils.map(null, (o) -> o);
    }

    @Test(expected=NullPointerException.class)
    public void testMapFIsNull() {
        LambdaUtils.map(new FutureTask<>(() -> ""), null);
    }

}
