package com.algorithm.practice.sieveoferatosthenes;

/**
 * @see <a href=
 *      "https://github.com/charles-wangkai/codility/blob/master/CountNonDivisible.java">Charles
 *      Wangkai's Solution</a>
 */
public class CountNonDivisible {
    public int[] solution(int[] numbers) {
        int[] counts = new int[numbers.length * 2 + 1];
        for (int number : numbers) {
            counts[number]++;
        }

        int[] divisorNums = new int[counts.length];
        for (int i = 1; i * i < divisorNums.length; i++) {
            for (int j = i * i; j < divisorNums.length; j += i) {
                divisorNums[j] += counts[i];
                if (j != i * i) {
                    divisorNums[j] += counts[j / i];
                }
            }
        }

        int[] result = new int[numbers.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = numbers.length - divisorNums[numbers[i]];
        }
        return result;
    }
}
