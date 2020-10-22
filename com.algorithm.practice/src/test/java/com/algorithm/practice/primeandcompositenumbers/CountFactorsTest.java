package com.algorithm.practice.primeandcompositenumbers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class CountFactorsTest {
    private static Object[][] cases() {
        return new Object[][] {
            {24, 8},
            {1, 1},
            {2, 2},
            {3, 2},
            {5, 2},
            {4, 3},
        };
    }

    @ParameterizedTest
    @MethodSource("cases")
    public void should_return_count_of_factors(int number, int expected) {
        // Given
        CountFactors sut = new CountFactors();

        // When
        int actual = sut.solution(number);

        // Then
        assertEquals(expected, actual);
    }
}
