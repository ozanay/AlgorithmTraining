package com.algorithm.practice.countingelements;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class MaxCountersTest {
    private static Object[][] cases() {
        return new Object[][] { 
            {new int[] { 3, 4, 4, 6, 1, 4, 4 }, 5, new int[] {3, 2, 2, 4, 2} }, 
            {new int[] { 3, 4, 4, 6, 1, 4, 4, 6, 5 }, 5, new int[] {4, 4, 4, 4, 5} },
            {new int[] { 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 7 }, 6, new int[] {10, 10, 10, 10, 10, 10} }
        };
    }

    @ParameterizedTest
    @MethodSource("cases")
    @DisplayName("Should return counters.")
    public void should_return_max_counters(int[] operations, int counterCount, int[] expected) {
        // Given
        MaxCounters sut = new MaxCounters();

        // When
        int[] actual = sut.createCounters(counterCount, operations);

        // Then
        assertArrayEquals(expected, actual);
    }
}
