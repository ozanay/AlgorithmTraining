package com.algorithm.practice.sorting;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * Task Score 93% Correctness 100% Performance 87%
 */
public class NumberOfDiscIntersectionsTest {
    private static Object[][] cases() {
        return new Object[][] {
            {new int[] {1, 5, 2, 1, 4, 0, 0, 0, 1, 3}, 21},
            {new int[] {1, 5, 2, 1, 4, 0}, 11}
        };
    }

    @ParameterizedTest
    @MethodSource("cases")
    public void should_return_number_of_discs_intersections(int[] input, int expected) {
        // Given
        NumberOfDiscIntersections sut = new NumberOfDiscIntersections();

        // When
        int actual = sut.solution(input);

        // Then
        assertEquals(expected, actual, StringUtils.join(input, "-"));
    }
}
