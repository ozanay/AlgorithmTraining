package com.algorithm.practice.prefixsums;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class CountDivTest {
    private static Object[][] cases() {
        return new Object[][] {
            {0, 0, 3, 1},
            {0, 1, 3, 1},
            {0, 4, 3, 2},
            {1, 3, 3, 1},
            {1, 2, 3, 0},
            {11, 25, 8, 2},
            {11, 24, 8, 2},
            {16, 25, 8, 2},
            {16, 24, 8, 2},
            {11, 345, 17, 20},
            {11, 14, 2, 2},
            {11, 15, 2, 2},
            {12, 16, 2, 3},
            {6, 11, 2, 3},
            {6, 6, 2, 1},
            {7, 7, 2, 0},
            {7, 8, 3, 0},
            {9, 21, 3, 5}
        };
    }

    @ParameterizedTest
    @MethodSource("cases")
    @DisplayName("Should count divisibles.")
    public void should_count_divisibles(int start, int end, int divider, int expected) {
        // Given
        CountDiv sut = new CountDiv();

        // When
        int actual = sut.count(start, end, divider);

        // Then
        assertEquals(expected, actual);
    }
}
