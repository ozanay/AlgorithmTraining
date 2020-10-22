package com.algorithm.practice.timecomplexity;

public class PermMissingElem {
    public int findMissingElement(int[] arr) {
        // write your code in Java SE 8
        boolean[] indexCheckArr = new boolean[arr.length + 1];
        for (int index : arr) {
            indexCheckArr[index - 1] = true;
        }

        for (int i = 0; i < indexCheckArr.length; i++) {
            if (!indexCheckArr[i]) {
                return i + 1;
            }
        }

        throw new IllegalArgumentException("Given arr should include missing element!");
    }
}
