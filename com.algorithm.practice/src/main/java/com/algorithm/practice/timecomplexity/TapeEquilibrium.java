package com.algorithm.practice.timecomplexity;

import java.util.Arrays;

public class TapeEquilibrium {
    public int calculateTapeDifference(int[] arr) {
        // write your code in Java SE 8
        int totalSum = Arrays.stream(arr).sum();
        int minDifference = Integer.MAX_VALUE;
        int tapeSum = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            tapeSum += arr[i];
            int remainingTapeSum = totalSum - tapeSum;
            int diff = Math.abs(tapeSum - remainingTapeSum);
            if (minDifference > diff) {
                minDifference = diff;
            }
        }

        return minDifference;
    }
}
