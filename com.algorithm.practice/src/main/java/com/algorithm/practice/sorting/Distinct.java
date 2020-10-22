package com.algorithm.practice.sorting;

import java.util.HashSet;
import java.util.Set;

public class Distinct {
    public int solution(final int[] input) {
        // write your code in Java SE 11
        Set<Integer> distincts = new HashSet<>();
        for (int i = 0; i < input.length; i++) {
            distincts.add(input[i]);
        }

        return distincts.size();
    }
}
