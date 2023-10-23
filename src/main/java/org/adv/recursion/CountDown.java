package org.adv.recursion;

public class CountDown {
    public static void main(String[] args) {
        System.out.println("Result : " + powerFunc(10, 2));
        System.out.println("Factorial : " + factorial(5));

    }

    public static void countDown(int number) throws InterruptedException {
        if (number == 0) {
            System.out.println("Done");
        } else {
            System.out.println(number);
            Thread.sleep(1000);
            countDown(number - 1);
        }
    }

    public static int powerFunc(int base, int power) {
        if (power == 0) {
            return 1;
        } else {
            return base * powerFunc(base, (power - 1));
        }
    }

    public static int factorial(int number) {
        if(number == 0) {
            return 1;
        } else {
            return number * factorial(number - 1);
        }
    }
}
