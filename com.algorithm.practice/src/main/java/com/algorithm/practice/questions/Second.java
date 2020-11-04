package com.algorithm.practice.questions;

import java.util.HashMap;

public class Second {
    public int solution(int[] numbers) {
        if (numbers.length == 1) {
            return 1;
        }

        HashMap<Integer, Integer> countMap = createNumberCountsMap(numbers);
        int lastIndex = numbers.length - 1;
        int start = 0;
        int end = lastIndex;
        boolean startStop = false;
        boolean endStop = false;
        while(start <= end) {
            int fromStart = numbers[start];
            Integer fromStartCount = countMap.get(fromStart);
            if (fromStartCount != 1) {
                start++;
                countMap.put(fromStart, --fromStartCount);
            } else {
                startStop = true;
            }

            int fromEnd = numbers[end];
            Integer fromEndCount = countMap.get(fromEnd);
            if (fromEndCount != 1) {
                end--;
                countMap.put(fromEnd, --fromEndCount);
            } else {
                endStop = true;
            }

            if (startStop && endStop) {
                break;
            }

        }

        return end - start + 1;
    }

    private HashMap<Integer, Integer> createNumberCountsMap(int[] numbers) {
        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int number : numbers) {
            if (countMap.containsKey(number)) {
                countMap.put(number, countMap.get(number) + 1);
            } else {
                countMap.put(number, 1);
            }
        }

        return countMap;
    }
}
