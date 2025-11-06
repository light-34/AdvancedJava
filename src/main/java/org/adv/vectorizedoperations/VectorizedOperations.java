package org.adv.vectorizedoperations;

import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.RealVector;
import org.apache.commons.lang3.ArrayUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class VectorizedOperations {
    public static void main(String[] args) {
        double[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        double[] arr2 = {11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        //vectorizedOperationsJStream();
        vectorizedOperationsApachee();
        vectorizedOperationsJStream(arr1, arr2);
    }

    //Use java stream to add to matrix
    public static void vectorizedOperationsJStream(int[] arr1, int[] arr2) {
        int[] result = IntStream.range(0, arr1.length).map(i -> arr1[i] + arr2[i]).toArray();
        Arrays.stream(result).forEach(System.out::println);
    }

    public static void vectorizedOperationsJStream(double[] arr1, double[] arr2) {
        List<Double> resultList = new ArrayList<>();
        Arrays.stream(arr1).forEach(resultList::add);

        double result = resultList.stream().reduce((a, b) -> a + b).get();
        System.out.println(result);

//        double[] result = Arrays.stream(arr1).map(i -> {
//            double vari = 1.1;
//            for(double d : arr2) {
//                vari = i * d;
//            }
//            return vari;
//        }).toArray();
//
//        Arrays.stream(result).forEach(System.out::println);

    }

    public static void vectorizedOperationsApachee() {
        double[] arr1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        double[] arr2 = {11, 12, 13, 14, 15, 16, 17, 18, 19, 20};
        RealVector v1 = new ArrayRealVector(arr1);
        RealVector v2 = new ArrayRealVector(arr2);
        RealVector result = v1.add(v2);
        System.out.println(result);
    }




}
