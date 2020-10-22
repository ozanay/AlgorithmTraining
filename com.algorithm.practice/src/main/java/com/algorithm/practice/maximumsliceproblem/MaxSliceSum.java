package com.algorithm.practice.maximumsliceproblem;

public class MaxSliceSum {
    public int solution(int[] numbers) {
        if (numbers.length == 1) {
            return numbers[0];
        }

        int max = numbers[0];
        int totalSum = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            int currentSum = totalSum + numbers[i];
            totalSum = (currentSum < numbers[i]) ? numbers[i] : currentSum;
            if (totalSum > max) {
                max = totalSum;
            }
        }

        return max;
    }
}
