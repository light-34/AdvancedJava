package org.adv.matrix;

import java.util.List;

public class MatrixDemo {
    public static void main(String[] args) {
        MatrixMethods methods = new MatrixMethods();
//        List<List<Integer>> first = List.of(List.of(1,2), List.of(3,4));
//        List<List<Integer>> second = List.of(List.of(5,6), List.of(7, 8));
//
//        System.out.println(methods.addOrSubtractMatrix(first, second, "-"));

        //Multiplication Test
        List<List<Integer>> third = List.of(List.of(1, 2, 3), List.of(4, 5, 6), List.of(4, 5, 6), List.of(5, 7, 9), List.of(10, 15, 20));
        List<List<Integer>> fourth = List.of(List.of(7, 8, 9), List.of(9, 10, 11), List.of(11, 12, 13));
        System.out.println(methods.multiplicationMatrix(third, fourth));
    }
}
