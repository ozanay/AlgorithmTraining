package com.algorithm.practice.countingelements;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class FrogRiverOneTest {
    private static Object[][] cases() {
        return new Object[][] {
            {new int[]{1, 3, 1, 4, 2, 3, 5, 4}, 5, 6},
            {new int[]{1, 3, 1, 4, 2, 3, 4, 1, 3, 2, 1}, 5, -1},
            {new int[]{1}, 5, -1}
        };
    }

    @ParameterizedTest
    @MethodSource("cases")
    @DisplayName("Should return earliest time that frog can pass river.")
    public void should_return_earliest_time_to_pass_river(int[] leaves, int target, int expected) {
        // Given
        FrogRiverOne sut = new FrogRiverOne();

        // When
        int earliestTime = sut.findEarliestTime(target, leaves);

        // Then
        assertEquals(expected, earliestTime);
    }
}
