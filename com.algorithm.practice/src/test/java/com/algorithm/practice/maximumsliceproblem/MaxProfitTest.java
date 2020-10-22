package com.algorithm.practice.maximumsliceproblem;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class MaxProfitTest {
    private static Object[][] cases() {
        return new Object[][] { 
            { new int[] { 23171, 21011, 21123, 21366, 21013, 21367 }, 356 } 
        };
    }

    @ParameterizedTest
    @MethodSource("cases")
    public void should_return_max_profit(int[] prices, int expected) {
        // Given
        MaxProfit sut = new MaxProfit();

        // When
        int actual = sut.solution(prices);

        // Then
        assertEquals(expected, actual);
    }
}
