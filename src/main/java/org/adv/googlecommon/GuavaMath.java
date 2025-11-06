package org.adv.googlecommon;

import com.google.common.math.DoubleMath;
import com.google.common.math.Stats;

import java.math.RoundingMode;
import java.util.List;

public class GuavaMath {

    public static void main(String[] args) {
        double result = DoubleMath.factorial(5); // 120
        double mean = Stats.meanOf(1.1, 2, 3, 4, 5.5);
        double rounding = DoubleMath.roundToInt(1.5, RoundingMode.HALF_UP);

        List<Double> list = List.of(1.1, 2.4, 3.3, 4.4, 5.5);
        double listRound = Stats.meanOf(list);

        List<Number> listNumber = List.of(1, 2, 3, 4, 5, 5.5);
        Stats stats = Stats.of(listNumber);
        double min = stats.min();
        double max = stats.max();
        double meanStats = stats.mean();
        long count = stats.count();
        double sum = stats.sum();
        double populationVariance = stats.populationVariance();
        double sampleVariance = stats.sampleVariance();
        double standardDeviation = stats.sampleStandardDeviation();

        String str = String.format("Max: %f, Min: %f, Mean: %f, Count: %d, Sum: %f, Population Variance: %f, Sample Var: %f, Standard Deviation: %f", max, min,  meanStats, count, sum, populationVariance, sampleVariance, standardDeviation);
        printInput(str);

        printInput(result);
        printInput(mean);
        printInput(rounding);
        printInput(listRound);
    }

    public static <T> void printInput(T input) {
        System.out.println(input);
    }
}
