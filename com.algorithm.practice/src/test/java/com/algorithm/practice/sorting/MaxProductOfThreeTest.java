package com.algorithm.practice.sorting;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class MaxProductOfThreeTest {
    private static Object[][] cases() {
        return new Object[][] {
            {new int[] {-5, 3, -5, 4}, 100},
            {new int[] {-5, 3, 5, 4}, 60},
            {new int[] {-5, -6, -4, -7, -10}, -120},
            {new int[] {0, 0, 0}, 0},
            {new int[] {1, 1, 2}, 2},
            {new int[] {-1, 1, 2}, -2},
            {new int[] {1, 2, 2}, 4},
            {new int[] {1, 2, 3, 4}, 24},
            {new int[] {-3, 1, 2, -2, 5, 6}, 60},
            {new int[] {1, 2, 3}, 6},
            {new int[] {1, 2, 3, -4}, 6},
        };
    }

    @ParameterizedTest
    @MethodSource("cases")
    public void should_return_maximal_product_of_any_triplet(int[] input, int expected) {
        // Given
        MaxProductOfThree sut = new MaxProductOfThree();

        // When
        int actual = sut.solution(input);

        // Then
        assertEquals(expected, actual);
    }
}
