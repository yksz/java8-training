package ch03.ex18;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

import org.junit.Test;

public class ThrowableFunctionTest {

    @Test
    public void testUnchecked() {
        List<String> out = new ArrayList<>();
        ThrowableFunction.unchecked((String s) -> out.add(s)).apply("hoge");
        assertEquals("hoge", out.get(0));
    }

    @Test
    public void testUncheckedThrowException() {
        Exception e = new Exception();
        Function<Object, Object> f = ThrowableFunction.unchecked(o -> { throw e; });
        try {
            f.apply(null);
            fail();
        } catch (RuntimeException re) {
            assertEquals(e, re.getCause());
        }
    }

}
