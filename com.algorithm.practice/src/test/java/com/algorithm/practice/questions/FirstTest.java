package com.algorithm.practice.questions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class FirstTest {
    private static Object[][] cases() {
        return new Object[][] { 
            {new String[] {
                "test1a", "test2", "test1b", "test1c", "test3"
            }, new String[]{
                "Wrong answer", "OK", "Runtime error", "OK", "Time limit exceeded"
            }, 33}, 
            {new String[] {
                "codility1", "codility3", "codility2", "codility4b", "codility4a"
            }, new String[]{
                "Wrong answer", "OK", "OK", "Runtime error", "OK"
            }, 50}, 
                { new String[] { "codility1" }, new String[] { "OK" }, 100 }, 
                { new String[] { "codility1" }, new String[] { "Runtime error" }, 0 }, 
        };
    }

    @ParameterizedTest
    @MethodSource("cases")
    public void first_test(String[] names, String[] results, int expected) {
        // Given
        First sut = new First();

        // When
        int actual = sut.solution(names, results);

        // Then
        assertEquals(expected, actual);
    }
}
