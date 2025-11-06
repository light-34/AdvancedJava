package org.adv.statistics;

import org.apache.commons.math3.fraction.Fraction;

public class StatisticsDemo {
    public static void main(String[] args) {
        StatisticsMethods.getFraction(new Fraction(1,2), new Fraction(1,2));
        StatisticsMethods.getVectorIntersection();
    }
}
