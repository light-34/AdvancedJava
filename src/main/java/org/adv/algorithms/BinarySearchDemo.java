package org.adv.algorithms;

public class BinarySearchDemo {
    public static void main(String[] args) {

        int[] numbers = {1, 2, 3, 5, 90, 100, 120, 123, 125};

        int[] numArr = {1, 2, 3, 7, 5, 90, 100, 120, 123, 125};

        System.out.println(binarySearch(numbers, 3));
        System.out.println(binarySearch(numArr, 200));

    }

    public static String binarySearch(int [] numbers, int number) {
        if (isListSorted(numbers)) {
            return "Please insert a sorted array or list";
        } else {
            int lowerIdx = 0;
            int upperIdx = numbers.length -1;

            while (lowerIdx <= upperIdx) {
                int midPoint = Math.floorDiv((lowerIdx + upperIdx), 2);

                if (numbers[midPoint] == number)
                    return String.valueOf(midPoint);

                if (number > numbers[midPoint])
                    lowerIdx = midPoint + 1;
                else
                    upperIdx = midPoint -1;
            }

            return "No Number Found";
        }

    }

    public static boolean isListSorted(int[] numbers) {
        int len = numbers.length - 1;

        for (int i = 0; i < len; i++) {
            if (numbers[i] > numbers[i + 1])
                return false;
        }

        return true;
    }
}
