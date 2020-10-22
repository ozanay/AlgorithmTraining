package com.algorithm.practice.sorting;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class DistinctTest {
    private static Object[][] cases() {
        return new Object[][] {
            {new int[] {4, 2, 2, 5, 1, 5, 8, 8, 1}, 5},
            {new int[] {2, 1, 1, 2, 3, 1}, 3},
            {new int[] {2, 1, 1, 2, 1}, 2}
        };
    }

    @ParameterizedTest
    @MethodSource("cases")
    public void should_return_distinct_element(int[] input, int expected) {
        // Given
        Distinct sut = new Distinct();

        // When
        int actual = sut.solution(input);

        // Then
        assertEquals(expected, actual);
    }
}
