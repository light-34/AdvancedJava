package org.adv.algorithms;

import java.util.Arrays;

public class MergeSortDemo {
    public static void main(String[] args) {
        int[] numbers = {1, 29, 34, 3, 98, 4, 87, 43, 21, 12};
        Arrays.stream(mergeSortDemo(numbers)).forEach(e -> System.out.print(e + " "));

    }

    public static int[] mergeSortDemo(int[] numbers) {
        int len = numbers.length;

        if (len > 1) {
            int mid = len / 2;

            //This will continuously divide array in to two
            int[] leftNumbers = Arrays.copyOfRange(numbers, 0, mid);
            int[] rightNumbers = Arrays.copyOfRange(numbers, mid, len);

            //recursively call the array
            mergeSortDemo(leftNumbers);
            mergeSortDemo(rightNumbers);

            //indexes for the arrays
            int lIdx = 0; //left array
            int rIdx = 0; //right array
            int fIdx = 0; //final array

            //add elements from smaller to larger in final array
            while (lIdx < leftNumbers.length && rIdx < rightNumbers.length) {
                if (leftNumbers[lIdx] < rightNumbers[rIdx]) {
                    numbers[fIdx] = leftNumbers[lIdx];
                    lIdx++;
                } else {
                    numbers[fIdx] = rightNumbers[rIdx];
                    rIdx++;
                }
                fIdx++;
            }

            //if left array still consists of elements
            while (lIdx < leftNumbers.length) {
                numbers[fIdx] = leftNumbers[lIdx];
                lIdx++;
                fIdx++;
            }

            //if right array still consists of elements
            while (rIdx < rightNumbers.length) {
                numbers[fIdx] = rightNumbers[rIdx];
                rIdx++;
                fIdx++;
            }
        }

        return numbers;
    }
}
