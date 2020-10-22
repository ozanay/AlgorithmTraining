package com.algorithm.practice.leader;

import java.util.HashMap;
import java.util.LinkedList;

public class Dominator {
    public int solution(int[] numbers) {
        if (numbers.length == 0) {
            return -1;
        }

        HashMap<Integer, DominatorInfo> dominatorMap = new HashMap<>();
        for (int i = 0; i<numbers.length; i++) {
            int number = numbers[i];
            if (dominatorMap.containsKey(number)) {
                DominatorInfo dominatorInfo = dominatorMap.get(number);
                dominatorInfo.increment();
                dominatorInfo.addIndex(i);
            } else {
                dominatorMap.put(number, new DominatorInfo(i));
            }
        }

        return dominatorMap.entrySet().stream().filter(map -> map.getValue().count > (numbers.length / 2))
                .map(map -> map.getValue().getFirstIndex()).findFirst().orElse(-1);
    }

    private static class DominatorInfo {
        private LinkedList<Integer> indices;
        private int count;

        private DominatorInfo(int initialIndex) {
            this.indices = new LinkedList<>();
            indices.add(initialIndex);
            this.count = 1;
        }

        private void increment() {
            count++;
        }

        private void addIndex(int index) {
            indices.add(index);
        }

        private int getFirstIndex() {
            return indices.getFirst();
        }
    }
}
