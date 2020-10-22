package com.algorithm.practice.timecomplexity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class FrogJmpTest {
    private static Object[][] cases() {
        return new Object[][] {
            {10, 85, 30, 3},
            {10, 240, 49, 5},
            {10, 250, 60, 4}
        };
    }

    private FrogJmp sut;

    @BeforeEach
    public void setUp() {
        sut = new FrogJmp();
    }

    @ParameterizedTest
    @MethodSource("cases")
    public void should_return_minimum_jump(int start, int target, int jump, int expected) {
        // When
        int minJump = sut.countJumps(start, target, jump);

        // Then
        assertEquals(expected, minJump);
    }
}
