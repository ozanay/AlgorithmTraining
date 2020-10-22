package com.algorithm.practice.countingelements;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class PermCheckTest {
    private static Object[][] cases() {
        return new Object[][] {
            {new int[] { 4, 1, 3, 2}, 1},
            {new int[] { 4, 1, 3 }, 0}
        };
    }

    @ParameterizedTest
    @MethodSource("cases")
    public void should_return_permutation_check(int[] inputs, int expected) {
        // Given
        PermCheck sut = new PermCheck();

        // When
        int actual = sut.check(inputs);

        // Then
        assertEquals(expected, actual);
    }
}
