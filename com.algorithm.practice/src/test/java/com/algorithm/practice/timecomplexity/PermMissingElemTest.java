package com.algorithm.practice.timecomplexity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class PermMissingElemTest {
    private static Object[][] cases() {
        return new Object[][] {
            {new int[] {2, 3, 1, 5}, 4}
        };
    }

    private PermMissingElem sut;

    @BeforeEach
    public void setUp() {
        sut = new PermMissingElem();
    }

    @ParameterizedTest
    @MethodSource("cases")
    public void should_return_missing_element_in_indices(int[] arr, int expected) {
        // When
        int missingElement = sut.findMissingElement(arr);
        
        // Then
        assertEquals(expected, missingElement);
    }
}
