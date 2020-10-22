package com.algorithm.practice.dynamicprogramming;

public class MinAbsSum {
    int solution(int[] numbers) {
        if (numbers.length == 0) {
            return 0;
        }

        if (numbers.length == 1) {
            return numbers[0];
        }


        return minAbsSum(numbers, 1, numbers[0]);
    }

    private int minAbsSum(int[] numbers, int index, int sum) {
        if (index == numbers.length) {
            return Math.abs(sum);
        }

        int negativeSum = sum - numbers[index];
        int positiveSum = sum + numbers[index];
        index++;
        return Math.min(minAbsSum(numbers, index, negativeSum), minAbsSum(numbers, index, positiveSum));
    }
}
