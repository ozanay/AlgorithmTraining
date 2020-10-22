package com.algorithm.practice.leader;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class EquiLeader {
    public int solution(int[] numbers) {
        if (numbers.length == 1) {
            return 0;
        }

        Optional<DominatorInfo> dominatorOpt = findDominator(numbers);
        if (dominatorOpt.isPresent()) {
            DominatorInfo dominator = dominatorOpt.get();
            int scannedDominatorCount = 0;
            int equileaderCount = 0;
            for (int i = 0; i < numbers.length - 1; i++) {
                int number = numbers[i];
                if (number == dominator.value) {
                    scannedDominatorCount++;
                    int lengthFromStart = i + 1;
                    if (scannedDominatorCount > (lengthFromStart / 2)
                            && (dominator.count - scannedDominatorCount) > (numbers.length - lengthFromStart) / 2) {
                        equileaderCount++;
                    }
                }
            }

            return equileaderCount;
        }

        return 0;
    }

    private Optional<DominatorInfo> findDominator(int[] numbers) {
        Map<Integer, Integer> dominatorMap = new HashMap<>();
        for (int number : numbers) {
            int count = (dominatorMap.containsKey(number)) ? dominatorMap.get(number) + 1 : 1;
            dominatorMap.put(number, count);
        }

        return dominatorMap.entrySet().stream().filter(map -> map.getValue() > (numbers.length / 2))
                .map(map -> new DominatorInfo(map.getKey(), map.getValue())).findFirst();
    }

    private static class DominatorInfo {
        private int value;
        private int count;

        private DominatorInfo(int value, int count) {
            this.value = value;
            this.count = count;
        }
    }
}
