package com.algorithm.practice.timecomplexity;

public class FrogJmp {
    public int countJumps(int frogPosition, int targetPosition, int jumpAmount) {
        // write your code in Java SE 8
        int distance = targetPosition - frogPosition;
        if (distance % jumpAmount == 0) {
            return distance / jumpAmount;
        }

        return (distance / jumpAmount) + 1;
    }
}
