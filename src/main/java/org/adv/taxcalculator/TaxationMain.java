package org.adv.taxcalculator;

public class TaxationMain {
    public static void main(String[] args) {
        double num = 444000;
        System.out.println("Tax amount for is " + TaxCalculator.calculateIncomeTax(num));
    }
}
