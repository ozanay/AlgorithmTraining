package com.algorithm.practice.arrays;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class OddOccurrencesInArray {
    public int findUnpairedElement(int[] arr) {
        // write your code in Java SE 8
        Map<Integer, Integer> pairMap = new HashMap<>();
        for (int element : arr) {
            if (pairMap.containsKey(element)) {
                int count = pairMap.get(element) + 1;
                pairMap.put(element, count);
            } else {
                pairMap.put(element, 1);
            }
        }

        Set<Integer> keySet = pairMap.keySet();

        for (int currentKey : keySet) {
            int occurrences = pairMap.get(currentKey);

            // if occurs odd number of times, we found the unpaired value - no need to
            // continue checking
            if (occurrences % 2 == 1) {
                return currentKey;
            }
        }

        // should never get to here
        throw new IllegalArgumentException("shouldn't get to here - should've return unpaired value by now");
    }
}
