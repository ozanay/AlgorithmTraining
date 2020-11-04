package com.algorithm.practice.dynamicprogramming;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Random;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

public class NumberSolitaireTest {
    private static Object[][] cases() {
        return new Object[][] {
            {new int[] {-2, -5, -1, -2, -44, -22, -1, -40, -7, -8, -4, -100, -21}, -24},
            {new int[] {-2, -5, -1, -2, -44, -22, -1, -40, -7, -8, -4, -100, -9, -21}, -28},
            {new int[] {1, -2, 0, 9, -1, -2}, 8},
            {new int[] {-2, 5, 1}, 4},
            {new int[] {-3892, 2926, 6182, -4031, 4381, -1761, 7434, -8819, 6049, -5235, 9832, -1599, -5712, 5791,
                4205, -9797, 5562, -6442, 2112, -9854, -9005, 8051, 859, 5047, -5925, -9387, 5767, -7959, 5641,
                -4383, 8244, -7737 }, 76_454},
            {new int[] {-2050, -549, -7591, -5882, -1451, -8052, -8120, -6197, -1873, -3392, -3694, -7198, -610,
                    -1291, -4342, -3345, -5744, -5561, -90, -2876, -4325, -3893, -5411, -1217, -5598, -4543, -7674,
                    -3239, -7075, -8625, -5396, -3799 }, -14_329}
        };
    }

    @ParameterizedTest
    @MethodSource("cases")
    public void should_return_maximal_sum_of_numbers_on_marked_squares(int[] numbers, int expected) {
        // Given
        NumberSolitaire sut = new NumberSolitaire();

        // When
        int actual = sut.solution(numbers);

        // Then
        assertEquals(expected, actual);
    }

    @Test
    public void random_generator() {
        Random random = new Random();
        int[] rands = random.ints(-10_000, -1).limit(32).toArray();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < rands.length; i++) {
            builder.append(rands[i]);
            if (i != rands.length - 1) {
                builder.append(", ");
            }
        }

        String arr = builder.toString();
        System.out.println(arr);

        assertTrue(rands.length > 0);
    }
}
