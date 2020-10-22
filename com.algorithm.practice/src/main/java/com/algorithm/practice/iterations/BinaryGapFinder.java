package com.algorithm.practice.iterations;

public class BinaryGapFinder {
    private static final Character ONE = '1';

    public int find(int number) {
        // write your code in Java SE 8
        String binary = Integer.toBinaryString(number);
        int longestGap = 0;
        int index = binary.indexOf(ONE, 0);
        if (index < 0) {
            return longestGap;
        }

        while (index > -1) {
            int oneIndex = binary.indexOf(ONE, index + 1);
            if (oneIndex < 0) {
                break;
            }
            
            int gap = oneIndex - index - 1;
            if (gap > longestGap) {
                longestGap = gap;
            }

            index = oneIndex;
        }

        return longestGap;
    }
}
