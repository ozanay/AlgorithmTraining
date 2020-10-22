package com.algorithm.practice.prefixsums;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class PassingCarsTest {
    private static Object[][] cases() {
        return new Object[][] {
            {new int[] {0, 1, 0, 1, 1}, 5},
            {new int[] {1, 1, 0, 1, 1}, 2},
            {new int[] {1, 1, 1}, 0},
            {new int[] {0, 0, 0}, 0},
            {new int[] {0, 0}, 0},
            {new int[] {1, 0}, 0},
            {new int[] {1, 0, 0}, 0},
            {new int[] {1, 0, 0, 1}, 2}
        };
    }

    @ParameterizedTest
    @MethodSource("cases")
    public void should_return_passing_cars_count(int[] input, int expected) {
        // Given
        PassingCars sut = new PassingCars();

        // When
        int actual = sut.solution(input);

        // Then
        assertEquals(expected, actual);
    }
}
