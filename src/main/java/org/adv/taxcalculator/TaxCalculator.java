package org.adv.taxcalculator;

public class TaxCalculator {

    private static final double FIRST = 11001;
    private static final double SECOND = 44726;
    private static final double THIRD = 95376;
    private static final double FOURTH = 182101;
    private static final double FIFTH = 231251;
    private static final double SIXTH = 578126;
    private static final double [] percents = {0.1, 0.12, 0.22, 0.24, 0.32, 0.35, 0.37};

    public static double calculateIncomeTax(double income) {
        double totalTax;

        if (income < 0.0) {
            totalTax = 0.0;
        } else if (income < FIRST) {
            totalTax = getBracketTotal(income, percents[0]);
        } else if (income < SECOND) {
            totalTax = getTaxResult(income, 2);
        } else if (income < THIRD) {
            totalTax = getTaxResult(income, 3);
        } else if (income < FOURTH) {
            totalTax = getTaxResult(income, 4);
        } else if (income < FIFTH) {
            totalTax = getTaxResult(income, 5);
        } else if (income < SIXTH) {
            totalTax = getTaxResult(income, 6);
        } else {
            totalTax = getTaxResult(income, 7);
        }

        return totalTax;

    }

    private static double getTaxResult(double income, int num) {
        double total = 0.0;
        double reminder;

        for (int i = 0; i < num ; i++) {
            if (income > 0) {
                switch (i) {
                    case 0 -> {
                        total += getBracketTotal(FIRST, percents[i]);
                        income -= FIRST;
                    } case 1 -> {
                        reminder = SECOND - FIRST;
                        total += getBracketTotal(Math.min(income, reminder), percents[i]);
                        income -= reminder;
                    } case 2 -> {
                        reminder = THIRD - SECOND;
                        total += getBracketTotal(Math.min(income, reminder), percents[i]);
                        income -= reminder;
                    } case 3 -> {
                        reminder = FOURTH - THIRD;
                        total += getBracketTotal(Math.min(income, reminder), percents[i]);
                        income -= reminder;
                    } case 4 -> {
                        reminder = FIFTH - FOURTH;
                        total += getBracketTotal(Math.min(income, reminder), percents[i]);
                        income -= reminder;
                    } case 5 -> {
                        reminder = SIXTH - FIFTH;
                        total += getBracketTotal(Math.min(income, reminder), percents[i]);
                        income -= reminder;
                    } default -> total += getBracketTotal(income, percents[i]);
                }
            }
        }

        return total;
    }

    public static double getBracketTotal(double income, double percent) {
        return income * percent;
    }

}
