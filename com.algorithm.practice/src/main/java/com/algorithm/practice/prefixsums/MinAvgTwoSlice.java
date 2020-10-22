package com.algorithm.practice.prefixsums;

public class MinAvgTwoSlice {
    public int solution(int[] input) {
        // write your code in Java SE 11
        int sum2 = 0;
        int sum3 = 0;

        int index = -1;
        double minAvg = Double.MAX_VALUE;
        for (int i = 0; i < input.length - 2; i++) {
            sum2 = input[i] + input[i + 1];
            double minAvg2 = sum2 / 2.0;
            if (minAvg2 < minAvg) {
                minAvg = minAvg2;
                index = i;
            }

            sum3 = sum2 + input[i + 2];
            double minAvg3 = sum3 / 3.0;
            if (minAvg3 < minAvg) {
                minAvg = minAvg3;
                index = i;
            }
        }

        double minAvgLast2 = (input[input.length - 2] + input[input.length - 1]) / 2.0;
        if (minAvgLast2 < minAvg) {
            index = input.length - 2;
        } 

        return index;
    }
}
