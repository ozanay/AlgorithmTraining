package com.algorithm.practice.prefixsums;

public class PassingCars {
    public int solution(int[] input) {
        // write your code in Java SE 11
        int zeroCount = 0;
        int pairCount = 0;
        for (int i = 0; i < input.length; i++) {
            if (input[i] == 0) {
                zeroCount++;
            } else {
                pairCount += zeroCount;
                if (Math.abs(pairCount) > 1000000000) {
                    return -1;
                }
            }
        }

        return pairCount;
    }
}
