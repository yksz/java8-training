package ch03.ex20;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class LambdaUtilsTest {

    @Test
    public void testMap() {
        String[] src = { "1", "2", "3" };
        List<Integer> dst = LambdaUtils.map(Arrays.asList(src), Integer::valueOf);
        assertArrayEquals(new Integer[] { 1, 2, 3 }, dst.toArray());
    }

    @Test(expected=NullPointerException.class)
    public void testMapItemsIsNull() {
        LambdaUtils.map(null, o -> o);
    }

    @Test(expected=NullPointerException.class)
    public void testMapFIsNull() {
        LambdaUtils.map(new ArrayList<>(), null);
    }

}
