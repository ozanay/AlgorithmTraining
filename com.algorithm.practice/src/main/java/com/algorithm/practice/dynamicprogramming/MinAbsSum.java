package com.algorithm.practice.dynamicprogramming;

import java.util.Arrays;

/**
 * Task Score: 90% Correctness: 100% Performance: 80%
 */
public class MinAbsSum {
    int solution(int[] numbers) {
        if (numbers.length == 0) {
            return 0;
        }

        if (numbers.length == 1) {
            return numbers[0];
        }

        int[] absoluteNumbers = new int[numbers.length];
        int absoluteSum = 0;
        for (int i = 0; i < numbers.length; i++) {
            int number = Math.abs(numbers[i]);
            absoluteNumbers[i] = number;
            absoluteSum += number;
        }

        int max = absoluteNumbers[absoluteNumbers.length - 1];
        if (max >= (absoluteSum - max)) {
            return max - (absoluteSum - max);
        }

        Arrays.sort(absoluteNumbers);
        int difference = differenceStrategy(absoluteNumbers);
        int sumStrategy = sumStrategy(absoluteNumbers, absoluteSum);

        return Math.min(difference, sumStrategy);
    }

    private static int differenceStrategy(int[] numbers) {
        int difference = 0;
        for (int i = numbers.length - 1; i >= 0; i -= 2) {
            int current = numbers[i];
            if (i == 0) {
                difference = Math.abs(current - difference);
            } else {
                int previous = numbers[i - 1];
                difference = Math.abs(current - previous - difference);
            }
        }

        return difference;
    }

    private static int sumStrategy(int[] numbers, int sum) {
        int sumFromBeginning = 0;
        int remainingSum = sum;
        for (int i = 0; i < numbers.length - 1; i++) {
            int number = numbers[i];
            sumFromBeginning += number;
            remainingSum -= number;
            if (sumFromBeginning >= remainingSum) {
                break;
            }
        }

        return Math.abs(sumFromBeginning - remainingSum);
    }
}
