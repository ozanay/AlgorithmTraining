package com.algorithm.practice.stacksandqueues;

import java.util.Deque;
import java.util.LinkedList;

public class Fish {
    public int solution(int[] fishes, int[] directions) {
        if (fishes.length == 0) {
            return 0;
        }

        int remainingFishes = fishes.length;
        Deque<Integer> oncomingFishes = new LinkedList<>();
        int east = 0;
        for (int i = 0; i < directions.length; i++) {
            int currentFishWeight = fishes[i];
            int currentFishDirection = directions[i];
            if (currentFishDirection != east) {
                oncomingFishes.push(currentFishWeight);
            } else if (!oncomingFishes.isEmpty()) {
                int oncomingFish = oncomingFishes.peek();
                while (currentFishWeight > oncomingFish) {
                    remainingFishes--;
                    oncomingFishes.pop();
                    if (oncomingFishes.isEmpty()) {
                        break;
                    }

                    oncomingFish = oncomingFishes.peek();
                }

                if (currentFishWeight < oncomingFish) {
                    remainingFishes--;
                }
            }

        }

        return remainingFishes;
    }
}
