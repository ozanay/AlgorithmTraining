package com.algorithm.practice.arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class OddOccurrencesInArrayTest {
    @Test
    public void should_return_unpaired_element() {
        // Given
        int[] arr = new int[] {9, 3, 9, 3, 9, 7, 9};
        OddOccurrencesInArray occurrences = new OddOccurrencesInArray();

        // When
        int unpaired = occurrences.findUnpairedElement(arr);

        // Then
        assertEquals(7, unpaired);
    }
}