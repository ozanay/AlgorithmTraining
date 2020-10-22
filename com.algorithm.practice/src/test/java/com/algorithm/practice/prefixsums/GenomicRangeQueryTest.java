package com.algorithm.practice.prefixsums;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class GenomicRangeQueryTest {
    private static Object[][] cases() {
        return new Object[][] {
            {"GT", new int[] {0, 0, 1}, new int[] {0, 1, 1}, new int[] {3, 3, 4}},
            {"CAGCCTA", new int[] {2, 5, 0}, new int[] {4, 5, 6}, new int[] {2, 4, 1}}
        };
    }

    @ParameterizedTest
    @MethodSource("cases")
    public void should_return_minimal_factors_in_range(String S, int[] P, int[] Q, int[] expected) {
        // Given
        GenomicRangeQuery sut = new GenomicRangeQuery();

        // When
        int[] actual = sut.findMinFactorsInRange(S, P, Q);

        // Then
        assertArrayEquals(expected, actual);
    }
}
