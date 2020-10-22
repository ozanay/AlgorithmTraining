package com.algorithm.practice.primeandcompositenumbers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class PeaksTest {
    private static Object[][] cases() {
        return new Object[][] {
            {new int[] {1, 2, 3, 4, 3, 4, 1, 2, 3, 4, 6, 2}, 3}
        };
    }
    
    @ParameterizedTest
    @MethodSource("cases")
    public void should_return_maximum_number_of_blocks(int[] heights, int expected) {
        // Given
        Peaks sut = new Peaks();

        // When
        int actual = sut.solution(heights);

        // Then
        assertEquals(expected, actual);
    }
}
