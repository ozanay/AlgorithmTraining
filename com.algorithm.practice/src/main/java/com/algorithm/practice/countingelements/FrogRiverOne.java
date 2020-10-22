package com.algorithm.practice.countingelements;

import java.util.HashMap;
import java.util.Map;

public class FrogRiverOne {
    public int findEarliestTime(int target, int[] fallingLeaves) {
        // write your code in Java SE 11
        Map<Integer, Boolean> leafMap = new HashMap<>();
        int positionCountWithoutLeaf = target;
        for (int i = 0; i < fallingLeaves.length; i++) {
            if (!leafMap.containsKey(fallingLeaves[i])) {
                leafMap.put(fallingLeaves[i], true);
                positionCountWithoutLeaf--;

                if (positionCountWithoutLeaf == 0) {
                    return i;
                }
            }
        }


        return -1;
    }
}
