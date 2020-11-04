package com.algorithm.practice.questions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class SecondTest {
    private static Object[][] cases() {
        return new Object[][] {
            {new int[] {7, 5, 2, 7, 2, 7, 4 , 7}, 6},
            {new int[] {7, 3, 7, 3, 1, 3, 4, 1}, 5},
            {new int[] {2, 1, 1, 3, 2, 1, 1, 3}, 3},
            {new int[] {1}, 1},
        };
    }

    @ParameterizedTest
    @MethodSource("cases")
    public void second_test(int[] locations, int expected) {
        // Given
        Second sut = new Second();

        // When
        int actual = sut.solution(locations);

        // Then
        assertEquals(expected, actual);
    }
}
