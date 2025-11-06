package org.adv.algorithms;

public class GcdFinder {
    public static void main(String[] args) {
        System.out.println(gcdFinderDemo(96, 116));
    }

    public static int gcdFinderDemo(int a, int b) {
        while ( b != 0) {
            int temp = a;
            a = b;
            b = temp % b;
        }
        return a;
    }
 }
