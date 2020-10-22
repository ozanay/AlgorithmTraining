package com.algorithm.practice.countingelements;

public class MissingInteger {
    public int findMissing(int[] numbers) {
        // write your code in Java SE 8
        boolean[] hits = new boolean[numbers.length];
        for (int number : numbers) {
            if (number > 0 && number <= numbers.length) {
                hits[number - 1] = true;
            }
        }

        for (int i = 0; i < hits.length; i++) {
            if (!hits[i]) {
                return i + 1;
            }
        }

        return hits.length + 1;
    }
}
