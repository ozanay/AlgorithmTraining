package com.algorithm.practice.prefixsums;

public class CountDiv {
    public int count(int start, int end, int divider) {
        // write your code in Java SE 11
        if (start == 0) {
            return (end / divider) + 1;
        }

        if (start < divider) {
            return end / divider;
        }

        int startMod = start % divider;
        int exclusiveCountInRange = (end/divider) - (start/divider);
        return (startMod == 0) 
            ? exclusiveCountInRange + 1
            : exclusiveCountInRange;
    }
}
