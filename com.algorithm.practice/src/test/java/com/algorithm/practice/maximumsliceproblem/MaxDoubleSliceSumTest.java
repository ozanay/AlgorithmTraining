package com.algorithm.practice.maximumsliceproblem;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class MaxDoubleSliceSumTest {
    /**
     * 0 ≤ X < Y < Z < N
     */
    private static Object[][] cases() {
        return new Object[][] {
            {new int[] {0, 10, -5, -2, 0}, 10},
            {new int[] {5, 17, 0, 3}, 17},
            {new int[] {-1, 3, 2, 6, -1, 4, 5, -100, 200, 1, 5}, 220},
            {new int[] {3, 2, 1, 4}, 2},
            {new int[] {3, 2, 6, -1, 4, 5, -1}, 17},
            {new int[] {3, 2, 6, -1, 4, 5, -1, 2}, 17},
            {new int[] {3, 2, 6, -1, 4, 5, -10, 2}, 17},
            {new int[] {1, 2, 3}, 0},
            {new int[] {3, 2, 1, 0, 4, 10}, 7},
            {new int[] {1, 1, 1, 1, 1}, 2},
            {new int[] {1, 1, 1, 1, 1, 1}, 3},
            {new int[] {0, 0, 0, 0, 0, 0, 0}, 0},
            {new int[] {-1, -2, -3, -4, -5, -6}, 0},
            {new int[] {-1, -1, -1, -1, -1}, 0},
            {new int[] {3, 2, 6, -1, 4, 5, -1, 2}, 17},
            {new int[] {3, 2, 6, -1, 4, 5, -10, 2}, 17},
            {new int[] {-1, 3, 2, 6, -1, 4, 5, -10, 2}, 20},
        };
    }

    @ParameterizedTest
    @MethodSource("cases")
    public void should_return_max_of_doubele_slices(int[] input, int expected) {
        // Given
        MaxDoubleSliceSum sut = new MaxDoubleSliceSum();

        // When
        int actual = sut.solution(input);

        // Then
        assertEquals(expected, actual);
    }
}
