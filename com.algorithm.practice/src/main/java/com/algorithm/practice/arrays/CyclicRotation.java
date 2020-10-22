package com.algorithm.practice.arrays;

public class CyclicRotation {
    public int[] rotate(int[] arr, int rotateCount) {
        // write your code in Java SE 8
        int[] rotated = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            int rotatedIndex = (i + rotateCount) % arr.length;
            rotated[rotatedIndex] = arr[i];
        }

        return rotated;
    }
    
}
