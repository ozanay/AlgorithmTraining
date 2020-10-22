package com.algorithm.practice.stacksandqueues;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class FishTest {
    private static Object[][] cases() {
        return new Object[][] {
            {new int[] {4, 3, 4, 1, 5}, new int[] {0, 0, 0, 0, 0}, 5},
            {new int[] {4, 3, 4, 1, 5}, new int[] {1, 1, 1, 1, 1}, 5},
            {new int[] {4, 3, 4, 1, 5}, new int[] {0, 1, 0, 0, 0}, 4},
            {new int[] {4, 3, 2, 4, 5}, new int[] {0, 1, 0, 0, 0}, 3},
            {new int[] {4, 5, 3, 2, 4}, new int[] {0, 1, 1, 0, 0}, 2},
            {new int[] {44, 5, 3, 2, 4}, new int[] {1, 0, 0, 0, 0}, 1},
            {new int[] {44, 5, 3, 233, 444}, new int[] {1, 1, 1, 1, 0}, 1},
            {new int[] {4, 5, 3, 2, 4, 6}, new int[] {0, 1, 1, 0, 0, 0}, 2},
            {new int[] {4, 5, 2, 2, 3, 2, 4, 6}, new int[] {0, 1, 1, 1, 1, 0, 0, 0}, 2},
            {new int[] {4, 3, 2, 1, 5}, new int[] {0, 1, 0, 0, 0}, 2}
        };
    }

    @ParameterizedTest
    @MethodSource("cases")
    public void should_return_number_of_fish_that_stay_alive(int[] fishes, int[] directions, int expected) {
        // Given
        Fish sut = new Fish();

        // When 
        int actual = sut.solution(fishes, directions);

        // Then
        assertEquals(expected, actual);
    }
}
