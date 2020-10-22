package com.algorithm.practice.maximumsliceproblem;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class MaxSliceSumTest {
    private static Object[][] cases() {
        return new Object[][] {
            {new int[] {3, 2, -6, 4, 0}, 5}
        };
    }

    @ParameterizedTest
    @MethodSource("cases")
    public void should_return_max_sum_of_any_slice(int[] numbers, int expected) {
        // Given
        MaxSliceSum sut = new MaxSliceSum();

        // When
        int actual = sut.solution(numbers);

        // Then
        assertEquals(expected, actual);
    }
}
