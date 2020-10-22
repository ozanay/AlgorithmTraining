package com.algorithm.practice.primeandcompositenumbers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

public class Peaks {
    public int solution(int[] heights) {
        if (heights.length < 3) {
            return 0;
        }

        ArrayList<Integer> peaks = new ArrayList<>(heights.length);
        LinkedList<Integer> factors = new LinkedList<>();
        int heightsLength = heights.length;
        for (int i = 1; i < heightsLength - 1; i++) {
            if (heights[i - 1] < heights[i] && heights[i] > heights[i + 1]) {
                peaks.add(i);
            }

            if (heightsLength % i == 0) {
                factors.addFirst(i);
            }
        }

        factors.addFirst(heightsLength);

        int peaksSize = peaks.size();
        if (peaksSize < 2) {
            return peaksSize;
        }

        return findBlockCount(peaks, factors, heightsLength);
    }

    private int findBlockCount(ArrayList<Integer> peaks, LinkedList<Integer> factors, int heightsLength) {
        int result = 0;
        int peaksSize = peaks.size();
        for (int i = 0; i < factors.size(); i++) {
            int factor = factors.get(i);
            if (peaksSize >= factor) {
                int k = heightsLength / factor;
                boolean isValid = false;
                for (int j = 0; j < heightsLength; j += k) {
                    isValid = doesBlockContainAnyPeak(k, j, peaks);
                    if (!isValid) {
                        break;
                    }
                }

                if (isValid) {
                    result = factor;
                    break;
                }
            }
        }

        return result;
    }

    private static boolean doesBlockContainAnyPeak(int k, int index, ArrayList<Integer> peaks) {
        int resultIndex = Collections.binarySearch(peaks, index, (midValue, key) -> {
            int lowerEnd = key;
            int upperEnd = key + k - 1;
            if (midValue >= lowerEnd && midValue <= upperEnd) {
                return 0;
            }

            if (lowerEnd > midValue) {
                return -1;
            }

            return 1;
        });

        return resultIndex >= 0;
    }
}
