package com.algorithm.practice.stacksandqueues;

import java.util.Deque;
import java.util.LinkedList;

public class Nesting {
    private static final char OPEN = '(';

    public int solution(String str) {
        Deque<Character> stack = new LinkedList<>();
        if (str.isEmpty()) {
            return 1;
        }

        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (OPEN == charAt) {
                stack.push(charAt);
            } else {
                if (stack.isEmpty()) {
                    return 0;
                }
                
                stack.pop();
            }
        }

        return (stack.isEmpty()) ? 1 : 0;
    }
}
