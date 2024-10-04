package org.adv.allaboutcrypto;

public class CalculateDailyProfit {
    public static void main(String[] args) {
        System.out.println("Result is : " + calculateDailyProfit(10000, 2, 30));
    }

    public static double calculateDailyProfit(double startingBalance, double percentChange, int days){
        double result = startingBalance ;
        while (days >= 0) {
            result += result * percentChange / 100;
            days--;
        }
        return result;
    }
}
