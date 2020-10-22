package com.algorithm.practice.dynamicprogramming;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class MinAbsSumTest {
    private static Object[][] cases() {
        return new Object[][] {
            {new int[] {1, 5, 2, -2}, 0}
        };
    }

    @ParameterizedTest
    @MethodSource("cases")
    public void should_return_min_absolute_sum(int[] numbers, int expected) {
        // Given
        MinAbsSum sut = new MinAbsSum();

        // When 
        int actual = sut.solution(numbers);

        // Then
        assertEquals(expected, actual);
    }
}
