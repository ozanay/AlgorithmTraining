package com.algorithm.practice.sorting;

import java.util.Arrays;

public class Triangle {
    public int solution(int[] sideLengths) {
        Arrays.sort(sideLengths);
        for (int i = 0; i < sideLengths.length- 2; i++) {
            int first = sideLengths[i];
            int second = sideLengths[i + 1];
            int third = sideLengths[i + 2];
            if (isTriangle(first, second, third)) {
                return 1;
            }    
        }

        return 0;
    }

    private boolean isTriangle(int first, int second, int third) {
        return (long) first + (long) second > third 
            && (long) first + (long) third > second 
            && (long) second + (long) third > first;
    }
}