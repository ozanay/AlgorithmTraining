package com.algorithm.practice.sorting;

import java.util.ArrayList;
import java.util.List;

public class MaxProductOfThree {
    public int solution(int[] input) {
        // write your code in Java SE 11
        int max = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        if (input.length < 3) {
            return 0;
        }

        for (int i = 0; i < input.length; i++) {
            int current = input[i];
            if (current > max) {
                max3 = max2;
                max2 = max;
                max = current;
            } else if (current > max2) {
                max3 = max2;
                max2 = current;
            } else if (current > max3) {
                max3 = current;
            }
            
            if (current < 0) {
                if (input.length > 3 && current < min) {
                    min2 = min;
                    min = current;
                } else if (input.length > 4 && current < min2) {
                    min2 = current;
                }
            }
        }

        List<Integer> maxMins = new ArrayList<>();
        addMin(min, maxMins);
        addMin(min2, maxMins);
        maxMins.add(max);
        maxMins.add(max2);
        maxMins.add(max3);

        return findMaxProduct(maxMins);
    }

    private int findMaxProduct(List<Integer> maxMins) {
        int maxProduct = Integer.MIN_VALUE;
        for (int i = 0; i < maxMins.size() - 2; i++) {
            for (int j = i + 1; j < maxMins.size() - 1; j++) {
                for (int k = j + 1; k < maxMins.size(); k++) {
                    int currentProduct = maxMins.get(i) * maxMins.get(j) * maxMins.get(k);
                    if (currentProduct > maxProduct) {
                        maxProduct = currentProduct;
                    }
                }
            }
        }
        return maxProduct;
    }

    private void addMin(int min, List<Integer> maxMins) {
        if (min != Integer.MAX_VALUE) {
            maxMins.add(min);
        }
    }
}
