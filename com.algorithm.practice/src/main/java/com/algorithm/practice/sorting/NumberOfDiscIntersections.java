package com.algorithm.practice.sorting;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class NumberOfDiscIntersections {
    public int solution(int[] discInput) {
        // write your code in Java SE 11
        List<Disc> discs = new ArrayList<>();
        for (int i = 0; i < discInput.length; i++) {
            discs.add(new Disc(i, discInput[i]));
        }

        List<Disc> sortedDiscs = discs.stream().sorted((disc1, disc2) -> disc1.start - disc2.start)
                .collect(Collectors.toList());

        PairCounter counter = new PairCounter();
        int last = sortedDiscs.size() - 1;
        for (int i = 0; i < last; i++) {
            Disc current = sortedDiscs.get(i);
            if (sortedDiscs.get(i + 1).start <= current.end) {
                int index = findIndex(current, i, sortedDiscs);
                if (index != i) {
                    counter.increment(index - i);
                    if (counter.count > 10_000_000) {
                        return -1;
                    }
                }
            }
        }

        return counter.count;
    }

    private static class Disc {
        private int start;
        private int end;

        private Disc(int center, int radius) {
            start = center - radius;
            end = center + radius;
        }
    }

    private static class PairCounter {
        private int count = 0;

        private void increment(int add) {
            count += add;
        }
    }

    private int findIndex(Disc disc, int start, List<Disc> discs) {
        int right = discs.size() - 1;
        int left = start + 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            Disc search = discs.get(mid);
            if (disc.end >= search.start) {
                int midRight = mid + 1; 
                if (midRight == discs.size() || discs.get(midRight).start > disc.end) {
                    return mid;
                }

                left = midRight;
            } else {
                int midLeft = mid - 1; 
                if (discs.get(midLeft).start < disc.end) {
                    return midLeft;
                } 
                
                right = midLeft;
            }
        }

        return start; 
    }
}
