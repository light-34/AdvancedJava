package org.adv.taxcalculator;

public class TaxationMain {
    public static void main(String[] args) {
        double num = 444000;
        //System.out.println("Tax amount for is " + TaxCalculator.calculateIncomeTax(num));
        double tax = TaxCalculator.simpleTaxCalculator(1548);
        System.out.println(String.format("Total amount for is %.2f and with flexity %.2f", tax, (tax + 114.99)));
    }
}
