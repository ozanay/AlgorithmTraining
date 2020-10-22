package com.algorithm.practice.countingelements;

public class MaxCounters {
    public int[] createCounters(int counterCount, int[] operations) {
        int[] counters = new int[counterCount];
        int maxCounter = 0;
        int maxAppliedCounter = 0;
        for (int i = 0; i < operations.length; i++) {
            int operation = operations[i];
            int position = operation - 1;
             if (operation == counterCount + 1) {
                maxAppliedCounter = maxCounter;
            } else {
                if (counters[position] < maxAppliedCounter) {
                    counters[position] = maxAppliedCounter + 1;
                } else {
                    counters[position] = counters[position] + 1;
                }
                
                if (counters[position] > maxCounter) {
                    maxCounter = counters[position];
                } 
            }
        }

        for (int i = 0; i < counters.length; i++) {
            if (counters[i] < maxAppliedCounter) {
                counters[i] = maxAppliedCounter;
            }
        }

        return counters;
    }
}
