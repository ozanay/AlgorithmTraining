package com.algorithm.practice.stacksandqueues;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class NestingTest {
    private static Object[][] cases() {
        return new Object[][] {
            {")(", 0},
            {")", 0},
            {"(", 0},
            {"", 1},
            {"()", 1},
            {"((()()))", 1},
            {"(()))))", 0},
        };
    }

    @ParameterizedTest
    @MethodSource("cases")
    public void should_return_whether_string_properly_nested_or_not(String input, int expected) {
        // Given
        Nesting sut = new Nesting();

        // When
        int actual = sut.solution(input);

        // Then
        assertEquals(expected, actual);
    }
}
