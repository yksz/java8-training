package ch03.ex16;

import static org.junit.Assert.*;

import org.junit.Test;

public class LambdaUtilsTest {

    @Test
    public void tesstDoInOrderAsync() {
        LambdaUtils.doInOrderAsync(() -> 1, (o, t) -> {
            assertEquals(1, (int) o);
            assertNull(t);
        });
    }

    @Test
    public void tesstDoInOrderAsyncThrowException() {
        RuntimeException ex = new RuntimeException();
        LambdaUtils.doInOrderAsync(() -> { throw ex; }, (o, t) -> {
            assertNull(o);
            assertEquals(ex, t);
        });
    }

}
