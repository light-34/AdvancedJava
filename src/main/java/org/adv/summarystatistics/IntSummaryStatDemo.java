package org.adv.summarystatistics;

import java.util.ArrayList;
import java.util.IntSummaryStatistics;
import java.util.List;

public class IntSummaryStatDemo {
     List<Integer> ages = new ArrayList<>(List.of(20, 30, 40, 50, 60, 70));

    public IntSummaryStatistics getIntSummaryStatistics() {
        IntSummaryStatistics stats = new IntSummaryStatistics();
        ages.forEach(stats::accept);
        return stats;
    }

    public long getSum() {
        IntSummaryStatistics statistics = getIntSummaryStatistics();
        return statistics.getSum();
    }

    public double getAverage() {
        IntSummaryStatistics statistics = getIntSummaryStatistics();
        return statistics.getAverage();
    }

    public long getCount() {
        IntSummaryStatistics statistics = getIntSummaryStatistics();
        return statistics.getCount();
    }

    public long getMin() {
        IntSummaryStatistics statistics = getIntSummaryStatistics();
        return statistics.getMin();
    }

    public long getMax() {
        IntSummaryStatistics statistics = getIntSummaryStatistics();
        return statistics.getMax();
    }

}
