package com.algorithm.practice.leader;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class EquiLeaderTest {
    private static Object[][] cases() {
        return new Object[][] {
            {new int[] {4, 4, 2, 5, 3, 4, 4, 4}, 3},
            {new int[] {4, 3, 4, 4, 4, 2}, 2},
            {new int[] {0, 0}, 1},
            {new int[] {2}, 0},
        };
    }

    @ParameterizedTest
    @MethodSource("cases")
    public void should_return_number_of_equileaders(int[] input, int expected) {
        // Given
        EquiLeader sut = new EquiLeader();

        // When
        int actual = sut.solution(input);

        // Then
        assertEquals(expected, actual);
    }
}
