package com.algorithm.practice.primeandcompositenumbers;

/**
 * Task Score: 93% Correctness: 100% Performance: 85%
 */
public class Flags {
    public int solution(int[] heights) {
        if (heights.length < 3) {
            return 0;
        }

        FlagArray peaks = getPeaks(heights);
        int peaksSize = peaks.size();
        if (peaksSize < 3) {
            return peaksSize; 
        }

        int maxPossibleCount = getPossibleMaxFlagCount(peaks);
        int peaksCount = 0;
        while(peaksCount < maxPossibleCount) {
            FlagArray scannedPeaks = new FlagArray(peaksSize);
            scannedPeaks.add(peaks.getFirst());
            for (int i = 1; i < peaksSize; i++) {
                int current = peaks.get(i);
                int previous = scannedPeaks.getLast();
                if (current - previous >= maxPossibleCount) {
                    scannedPeaks.add(current);
                }
            }

            peaksCount = scannedPeaks.size();
            if (peaksCount < maxPossibleCount) {
                maxPossibleCount--;
            }
        }

        return maxPossibleCount;
    }

    private static int getPossibleMaxFlagCount(FlagArray peaks) {
        int maxPeakCountInTotalDistance = peaks.size() + 1;
        boolean isTotalDistanceValid = false;
        int first = peaks.getFirst();
        int last = peaks.getLast();
        int maxDistance = last - first;
        do {
            maxPeakCountInTotalDistance--;
            isTotalDistanceValid = maxDistance >= maxPeakCountInTotalDistance * (maxPeakCountInTotalDistance - 1);
        } while (!isTotalDistanceValid);

        return maxPeakCountInTotalDistance;
    }

    private static FlagArray getPeaks(int[] heights) {
        FlagArray peaks = new FlagArray(heights.length);
        for (int i = 1; i < heights.length - 1; i++) {
            int height = heights[i];
            if (heights[i - 1] < height && height > heights[i + 1]) {
                peaks.add(i);
            }
        }

        return peaks;
    }

    private static class FlagArray {
        private int[] elements;
        private int size;

        private FlagArray(int capacity) {
            this.elements = new int[capacity];
            this.size = 0;
        }

        private void add(int element) {
            elements[size] = element;
            size++;
        }

        private int get(int index) {
            return elements[index];
        }

        private int getLast() {
            return elements[size - 1];
        }

        private int getFirst() {
            return elements[0];
        }

        private int size() {
            return this.size;
        }
    }
}
