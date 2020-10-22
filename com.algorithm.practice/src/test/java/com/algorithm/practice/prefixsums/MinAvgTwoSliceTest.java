package com.algorithm.practice.prefixsums;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class MinAvgTwoSliceTest {
    private static Object[][] cases() {
        return new Object[][] {
            {new int[] {4, 2, 2, 5, 1, 5, 8}, 1},
            {new int[] {0, 0}, 0},
            {new int[] {0, 0, 0}, 0},
            {new int[] {0, 1}, 0},
            {new int[] {0, 1, 0}, 0}
        };
    }

    @ParameterizedTest
    @MethodSource("cases")
    public void should_return_starting_position_of_min_avg_slice(int[] input, int expected) {
        // Given
        MinAvgTwoSlice sut = new MinAvgTwoSlice();

        // When
        int actual = sut.solution(input);

        // Then
        assertEquals(expected, actual);
    }
}
