package com.algorithm.practice.iterations;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class BinaryGapFinderTest {
    public static Object[][] cases() {
        return new Object[][] {
            {1041, 5},
            {9, 2},
            {529, 4},
            {20, 1},
            {15, 0},
            {32, 0},
        };
    }

    @ParameterizedTest
    @MethodSource("cases")
    public void should_return_longest_gap(int number, int expected) {
        // Given
        BinaryGapFinder gap = new BinaryGapFinder();

        // When
        int longestGap = gap.find(number);

        // Then
        assertEquals(expected, longestGap, String.format("Number is %s", number));
    }
}