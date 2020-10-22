package com.algorithm.practice.stacksandqueues;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class StoneWallTest {
    private static Object[][] cases() {
        return new Object[][] {
            {new int[] {6, 6, 5, 5, 5, 2, 1}, 4},
            {new int[] {3, 4, 5, 5, 5, 2, 1}, 5},
            {new int[] {8, 8, 5, 7, 9, 8, 7, 4, 8}, 7},
            {new int[] {1, 2, 3, 4, 5, 6}, 6},
            {new int[] {6, 5, 4, 3, 2, 1}, 6},
            {new int[] {6, 6, 6, 6, 6, 6, 6}, 1},
            {new int[] {3, 4, 5, 5, 5, 6, 7}, 5},
            {new int[] {1}, 1},
        };
    }

    @ParameterizedTest
    @MethodSource("cases")
    public void should_return_minimum_number_of_blocks_to_construct_wall(int[] input, int expected) {
        // Given
        StoneWall sut = new StoneWall();

        // When
        int actual = sut.solution(input);

        // Then
        assertEquals(expected, actual);
    }
}
