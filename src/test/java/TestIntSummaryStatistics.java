import org.adv.summarystatistics.IntSummaryStatDemo;
import org.junit.Test;

import java.util.IntSummaryStatistics;

import static org.junit.Assert.*;

public class TestIntSummaryStatistics {
    IntSummaryStatDemo intSummaryStatistics = new IntSummaryStatDemo();

    @Test
    public void testIntSummaryStatSum() {
        assertEquals(270, intSummaryStatistics.getSum());
    }

    @Test
    public void testIntSummaryStatMin() {
        assertEquals(20, intSummaryStatistics.getMin());
    }

    @Test
    public void testIntSummaryStatMax() {
        assertEquals(70, intSummaryStatistics.getMax());
    }

    @Test
    public void testIntSummaryStatCont() {
        assertEquals(6, intSummaryStatistics.getCount());
    }
}
