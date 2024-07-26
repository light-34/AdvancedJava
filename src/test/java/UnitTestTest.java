import org.adv.unittestdemo.UnitTestDemo;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class UnitTestTest {
    UnitTestDemo unitTestDemo = new UnitTestDemo();

    @Test
    public void testAdd() {
        assertEquals(3, unitTestDemo.add(1, 2));
        assertEquals(-1, unitTestDemo.add(-3, 2));
    }

    @Test(expected = ArithmeticException.class)
    public void testDivide() {
        unitTestDemo.divide(3, 0);
    }

    @Test
    public void testThrowable() {
        assertThrows(ArithmeticException.class, () -> unitTestDemo.divide(-1, 0));
    }

    @Test
    public void testIsEqualTrue() {
        assertTrue(unitTestDemo.isEqual(1, 1));
    }

    @Test
    public void testIsEqualFalse() {
        assertFalse(unitTestDemo.isEqual(1, 2));
    }

    @Test
    public void testFormatDateTime() {
        LocalDateTime ldt = LocalDateTime.of(2020, 1, 1, 1, 1, 1);
        String pattern = "yyyy-MM-dd HH:mm:ss";
        assertEquals("2020-01-01 01:01:01",unitTestDemo.formatDateTime(ldt, pattern));
    }
}
