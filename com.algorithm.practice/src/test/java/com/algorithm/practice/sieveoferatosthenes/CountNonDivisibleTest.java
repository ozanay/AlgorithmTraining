package com.algorithm.practice.sieveoferatosthenes;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class CountNonDivisibleTest {
    private static Object[][] cases() {
        return new Object[][] {
            {new int[]{3, 1, 2, 3, 6}, new int[] {2, 4, 3, 2, 0}},
            {new int[]{1, 2, 3, 6}, new int[] {3, 2, 2, 0}},
            {new int[]{1, 3, 2, 3, 6}, new int[] {4, 2, 3, 2, 0}},
        };
    }

    @ParameterizedTest
    @MethodSource("cases")
    public void should_return_number_of_not_divisors_for_each_number(int[] numbers, int[] expected) {
        // Given
        CountNonDivisible sut = new CountNonDivisible();

        // When
        int[] actual = sut.solution(numbers);

        // Then
        assertArrayEquals(expected, actual);
    }
}
