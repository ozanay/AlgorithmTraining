package com.algorithm.practice.dynamicprogramming;

public class NumberSolitaire {
    public int solution(int[] numbers) {
        int sum = numbers[0] + numbers[numbers.length - 1];
        int indexLimit = numbers.length - 1;
        int index = 1;
        int negativeMaxIndex = index;
        int lastNonNegativeIndex = index;
        while (index < indexLimit) {
            int maxDieThrowIndex = index + 5;
            int dieThrowLimit = (maxDieThrowIndex) >= indexLimit ? indexLimit - 1 : maxDieThrowIndex;
            boolean nonNoneNegativeExistent = false;
            int negativeMax = Integer.MIN_VALUE;
            int negativeSecondMax = Integer.MIN_VALUE;
            int negativeSecondMaxIndex = -1;
            for (int i = index; i <= dieThrowLimit; i++) {
                int number = numbers[i];
                if (number >= 0) {
                    sum += number;
                    nonNoneNegativeExistent = true;
                    lastNonNegativeIndex = i;
                } else if (number >= negativeMax) {
                    negativeMax = number;
                    negativeMaxIndex = i;
                } else if (number > negativeSecondMax) {
                    negativeSecondMax = number;
                    negativeSecondMaxIndex = i;
                }
            }

            if (maxDieThrowIndex >= indexLimit) {
                break;
            }

            if (nonNoneNegativeExistent) {
                index = lastNonNegativeIndex + 1;
            } else {
                if (negativeSecondMaxIndex > negativeMaxIndex) {
                    int nextNegativeMax = Integer.MIN_VALUE;
                    boolean isAllNegative = true;
                    if (negativeMaxIndex + 6 < indexLimit) {
                        for (int i = negativeMaxIndex + 1; i <= negativeMaxIndex + 6; i++) {
                            int number = numbers[i];
                            if (number >= 0) {
                                isAllNegative = false;
                                break;
                            } else if (number >= nextNegativeMax) {
                                nextNegativeMax = number;
                            }
                        }

                        if (isAllNegative && nextNegativeMax == negativeMax) {
                            sum += negativeSecondMax;
                            index = negativeSecondMaxIndex + 1;
                        } else {
                            sum += negativeMax;
                            index = negativeMaxIndex + 1;
                        }
                    } else
                    {
                        sum += negativeMax;
                        index = negativeMaxIndex + 1;
                    }
                } else {
                    sum += negativeMax;
                    index = negativeMaxIndex + 1;
                }
            }
        }

        return sum;
    }
}
