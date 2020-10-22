package com.algorithm.practice.util;

public final class MathUtil {
    private MathUtil() {}
    
    public static int sum(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            int number = arr[i];
            sum += number;
        }

        return sum;
    }
}
