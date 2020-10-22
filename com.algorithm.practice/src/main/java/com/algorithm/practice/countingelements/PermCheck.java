package com.algorithm.practice.countingelements;

public class PermCheck {
    public int check(int[] inputs) {
        // write your code in Java SE 11
        boolean[] hits = new boolean[inputs.length];
        for (int input : inputs) {
            if (input > inputs.length) {
                return 0;
            }
            
            hits[input - 1] = true;
        }

        boolean isPermutation = true;
        for (boolean hit : hits) {
            if (!hit) {
                isPermutation = false;
                break;
            }
        }

        return isPermutation ? 1 : 0;
    }
}
