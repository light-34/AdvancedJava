package org.adv.matrix;

import java.util.ArrayList;
import java.util.List;

public class MatrixMethods {
    public List<List<Integer>> addOrSubtractMatrix(List<List<Integer>> fMatrix, List<List<Integer>> sMatrix, String op) {
        if (fMatrix.size() != sMatrix.size()) {
            System.out.println("These matrices cant be summed/subtracted. because row number is not identical");
            return null;
        } else if (fMatrix.get(0).size() != sMatrix.get(0).size()) {
            System.out.println("These matrices cant be summed/subtracted. because column number is not identical");
            return null;
        }

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < fMatrix.size(); i++) {
            List<Integer> innerFMatrix = fMatrix.get(i);
            List<Integer> innerSMatrix = sMatrix.get(i);
            List<Integer> innerResult = new ArrayList<>();

            for (int j = 0; j < innerFMatrix.size(); j++) {
                int numF = innerFMatrix.get(j);
                int numS = innerSMatrix.get(j);
                int sum;
                if (op.equals("+")) {
                    sum = numF + numS;
                } else {
                    sum = numF - numS;
                }

                innerResult.add(sum);
            }

            result.add(innerResult);
        }

        return result;
    }

    public List<List<Integer>> multiplicationMatrix(List<List<Integer>> fMatrix, List<List<Integer>> sMatrix) {
        if (fMatrix.get(0).size() != sMatrix.size()) {
            System.out.println("These matrices cant be multiplied. because number of columns in first matrix is not equal with the number of rows in second matrix");
            return null;
        }
        List<List<Integer>> result = new ArrayList<>();

        long initial = System.currentTimeMillis();

        for (List<Integer> innerFM : fMatrix) {
            int sum = 0;
            int count = 0;

            List<Integer> innerResult = new ArrayList<>();

            int val = sMatrix.size();

            while (val > 0) {
                for (int j = 0; j < innerFM.size(); j++) {
                    int numFM = innerFM.get(j); // 1
                    int numSM = sMatrix.get(j).get(count); //7

                    sum += numFM * numSM;
                }
                innerResult.add(sum);
                sum = 0;
                count++;
                val--;
            }

            result.add(innerResult);
        }

        long seconds = (System.currentTimeMillis() - initial);
        System.out.println("Total milliseconds : " + seconds);
        return result;
    }
}
