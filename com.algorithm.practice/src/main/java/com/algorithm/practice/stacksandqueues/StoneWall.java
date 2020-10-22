package com.algorithm.practice.stacksandqueues;

import java.util.Deque;
import java.util.LinkedList;

public class StoneWall {
    public int solution(int[] heights) {
        if (heights.length == 0) {
            return 0;
        }

        Deque<Integer> previousLowerWalls = new LinkedList<>();
        int minimumNumberOfBlocks = heights.length;
        previousLowerWalls.push(heights[0]);
        for (int i = 1; i < heights.length; i++) {
            int currentHeight = heights[i];
            int previous = previousLowerWalls.peek();

            while (previous > currentHeight) {
                previousLowerWalls.pop();
                if (previousLowerWalls.isEmpty()) {
                    break;
                }
                previous = previousLowerWalls.peek();
            }

            if (!previousLowerWalls.isEmpty() && previousLowerWalls.peek() == currentHeight) {
                minimumNumberOfBlocks--;
            } else {
                previousLowerWalls.push(currentHeight);
            }
        }

        return minimumNumberOfBlocks;
    }
}
