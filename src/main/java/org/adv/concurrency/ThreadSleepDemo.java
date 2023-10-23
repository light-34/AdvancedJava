package org.adv.concurrency;

public class ThreadSleepDemo {
    public static void main(String[] args) throws InterruptedException{

        /*String [] importantInfo = {
                "Mares eat oats",
                "Does eat oats",
                "Little lambs eat ivy",
                "A kid will eat ivy too"
        };

        for (String i: importantInfo) {
            Thread.sleep(4000);
            System.out.println(i);
        }*/

        int sec = 30;

        for (int i = sec; i > 0; i--) {
            System.out.print(sec);
            sec--;
            Thread.sleep(1000);
        }
    }
}
