package ch03.ex23;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.ExecutionException;

import org.junit.Test;

public class LambdaUtilsTest {

    @Test
    public void testMap() throws InterruptedException, ExecutionException {
        Pair<String> src = new Pair<>("1", "2");
        Pair<Integer> dst = LambdaUtils.map(src, Integer::valueOf);
        assertEquals((Integer) 1, dst.getFirst());
        assertEquals((Integer) 2, dst.getSecond());
    }

    @Test(expected=NullPointerException.class)
    public void testMapPairIsNull() {
        LambdaUtils.map(null, (o) -> o);
    }

    @Test(expected=NullPointerException.class)
    public void testMapFIsNull() {
        LambdaUtils.map(new Pair<>("", ""), null);
    }

}
