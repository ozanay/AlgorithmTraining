package com.algorithm.practice.leader;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class DominatorTest {
    private static Object[][] cases() {
        return new Object[][] {
            {new int[] {3, 4, 3, 2, 3, -1, 3, 3}, Arrays.asList(0, 2, 6, 7)},
            {new int[] {3, 4, 3, 2, 3, -1, 3, 4}, Arrays.asList(-1)},
            {new int[] {}, Arrays.asList(-1)},
            {new int[] {4}, Arrays.asList(0)},
        };
    }

    @ParameterizedTest
    @MethodSource("cases")
    public void should_return_dominator_number_in_input(int[] input, List<Integer> expectedNumbers) {
        // Given
        Dominator sut = new Dominator();

        // When
        int actual = sut.solution(input);

        // Then
        assertTrue(expectedNumbers.stream().anyMatch(number -> number == actual));
    }
}
