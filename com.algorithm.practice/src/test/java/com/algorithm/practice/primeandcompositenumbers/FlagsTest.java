package com.algorithm.practice.primeandcompositenumbers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class FlagsTest {
    private static Object[][] cases() {
        return new Object[][] {
            { new int[] {1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 1, 1, 1, 2, 1}, 4},
            { new int[] {1, 5, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2}, 3},
            { new int[] {1, 9, 8, 7, 6, 5, 4, 3, 7, 4, 6, 2}, 2},
            { new int[] {1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1, 2, 1}, 4}
        };
    }

    @ParameterizedTest
    @MethodSource("cases")
    public void should_return_max_number_of_peaks(int[] heights, int expected) {
        // Given
        Flags sut = new Flags();

        // When
        int actual = sut.solution(heights);

        // Then
        assertEquals(expected, actual);
    }
}
