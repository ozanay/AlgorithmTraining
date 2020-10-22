package com.algorithm.practice.maximumsliceproblem;

/**
 * Kadane's Algorithm Based Solution
 * 
 * @see <a href=
 *      "https://rafal.io/posts/codility-max-double-slice-sum.html">Rafal's solution</a>
 * 
 */
public class MaxDoubleSliceSum {
    public int solution(int[] numbers) {
        int length = numbers.length;
        int[] contiguousSumsFromStart = new int[length];
        int[] contiguousSumsFromEnd = new int[length];

        for (int i = 1; i < length - 1; i++) {
            contiguousSumsFromStart[i] = Math.max(contiguousSumsFromStart[i - 1] + numbers[i], 0);
        }
        for (int i = length - 2; i > 0; i--) {
            contiguousSumsFromEnd[i] = Math.max(contiguousSumsFromEnd[i + 1] + numbers[i], 0);
        }

        int max = 0;

        for (int i = 1; i < length - 1; i++) {
            max = Math.max(max, contiguousSumsFromStart[i - 1] + contiguousSumsFromEnd[i + 1]);
        }

        return max;
    }
}
