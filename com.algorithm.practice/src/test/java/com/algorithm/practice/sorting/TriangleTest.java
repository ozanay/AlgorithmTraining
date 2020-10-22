package com.algorithm.practice.sorting;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class TriangleTest {
    private static Object[][] cases() {
        return new Object[][] {
            {new int[] {10, Integer.MAX_VALUE, Integer.MAX_VALUE}, 1},
            {new int[] {10, 2, 5, 1, 8, 20}, 1},
            {new int[] {10, 50, 5, 1}, 0},
        };
    }

    @ParameterizedTest
    @MethodSource("cases")
    public void should_return_whether_triangle_exists_or_not(int[] input, int expected) {
        // Given
        Triangle sut = new Triangle();

        // When
        int actual = sut.solution(input);

        // Then
        assertEquals(expected, actual);
    }
}
