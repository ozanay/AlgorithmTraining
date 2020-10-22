package com.algorithm.practice.timecomplexity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class TapeEquilibriumTest {
    private static Object[][] cases() {
        return new Object[][] {
            {new int[]{-1000, 1000}, 2000},
            {new int[]{3, 1, 2, 4, 3}, 1}
        };
    }

    private TapeEquilibrium sut;

    @BeforeEach
    public void setUp() {
        sut = new TapeEquilibrium();
    }

    @ParameterizedTest
    @MethodSource("cases")
    public void should_return_min_absolute_difference_between_tapes(int[] arr, int expected) {
        // When
        int minDiff = sut.calculateTapeDifference(arr);

        // Then
        assertEquals(expected, minDiff);
    }
}
