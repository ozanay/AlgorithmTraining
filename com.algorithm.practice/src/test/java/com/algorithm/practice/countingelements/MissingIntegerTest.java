package com.algorithm.practice.countingelements;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class MissingIntegerTest {
    private static Object[][] cases() {
        return new Object[][] {
            {new int[] { 1, 2, 3 }, 4},
            {new int[] { 1, 3, 6, 4, 1, 2 }, 5},
            {new int[] { -1, -3 }, 1}
        };
    }

    @ParameterizedTest
    @MethodSource("cases")
    @DisplayName("Should return missing integer.")
    public void should_return_missing_integer(int[] numbers, int expected) {
        // Given
        MissingInteger sut = new MissingInteger();

        // When
        int actual = sut.findMissing(numbers);

        // Then
        assertEquals(expected, actual);
    }
}
