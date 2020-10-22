package com.algorithm.practice.arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class CyclicRotationTest {
    public static Object[][] cases() {
        return new Object[][] {
            {new int[]{3, 8, 9, 7, 6}, 3, new int[]{9, 7, 6, 3, 8}},
            {new int[]{1, 2, 3, 4}, 4, new int[]{1, 2, 3, 4}},
        };
    }

    @ParameterizedTest
    @MethodSource("cases")
    public void should_rotate_k_times(int[] arr, int rotateCount, int[] expected) {
        // Given
        CyclicRotation rotation = new CyclicRotation();

        // When
        int[] rotated = rotation.rotate(arr, rotateCount);

        // Then
        assertArrayEquals(expected, rotated);
    }
}
