package com.algorithm.practice.prefixsums;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GenomicRangeQuery {
    private static final Character A = 'A';
    private static final Character C = 'C';
    private static final Character G = 'G';

    public int[] findMinFactorsInRange(String S, int[] P, int[] Q) {
        // write your code in Java SE 11
        Map<Character, List<Integer>> indexMap = createIndexMap(S);
        int[] factors = new int[P.length];
        for (int i = 0; i < Q.length; i++) {
            int start = P[i];
            int end = Q[i];
            factors[i] = (start == end)
                ? getFactor(S.charAt(start))
                : findMinFactor(start, end, indexMap);
        }

        return factors;
    }

    private Map<Character, List<Integer>> createIndexMap(String S) {
        Map<Character, List<Integer>> indexMap = new HashMap<>();
        for (int i = 0; i < S.length(); i++) {
            char nucleotit = S.charAt(i);
            if (indexMap.containsKey(nucleotit)) {
                indexMap.get(nucleotit).add(i);
            } else {
                List<Integer> indeces = new ArrayList<>();
                indeces.add(i);
                indexMap.put(nucleotit, indeces);
            }
        }

        return indexMap;
    }

    private int findMinFactor(int start, int end, Map<Character, List<Integer>> indexMap) {
        List<Integer> indicesA = indexMap.get(A);
        if (indicesA != null && isNucleotitInList(start, end, indicesA)) {
            return 1;
        }

        List<Integer> indicesC = indexMap.get(C);
        if (indicesC != null && isNucleotitInList(start, end, indicesC)) {
            return 2;
        }

        List<Integer> indicesG = indexMap.get(G);
        if (indicesG != null && isNucleotitInList(start, end, indicesG)) {
            return 3;
        }

        return 4;
    }

    private boolean isNucleotitInList(int start, int end, List<Integer> indices) {
        return binarySearch(indices, 0, indices.size() - 1, start, end);
    }

    private boolean binarySearch(List<Integer> indices, int left, int right, int start, int end) {
        while(left <= right) {
            int mid = (left + right) / 2;
            int index = indices.get(mid);
            if (index >= start && index <= end) {
                return true;
            } else if (start > index) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        // We reach here when element is not present
        // in array
        return false;
    }

    private int getFactor(char nucleotit) {
        if (A.equals(nucleotit)) {
            return 1;
        }

        if (C.equals(nucleotit)) {
            return 2;
        }

        if (G.equals(nucleotit)) {
            return 3;
        }

        return 4;
    }
}
