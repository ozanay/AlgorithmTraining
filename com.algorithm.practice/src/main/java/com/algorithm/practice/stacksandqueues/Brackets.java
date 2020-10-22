package com.algorithm.practice.stacksandqueues;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;


public class Brackets {
    private static final Map<Character, Character> pairMap = new HashMap<>();
    static {
        pairMap.put('(', ')');
        pairMap.put('{', '}');
        pairMap.put('[', ']');
    }

    public int solution(String str) {
        Deque<Character> stack = new LinkedList<>();
        if (str.isEmpty()) {
            return 1;
        }

        for (int i = 0; i < str.length(); i++) {
            char charAt = str.charAt(i);
            if (pairMap.containsKey(charAt)) {
                stack.push(charAt);
            } else {
                if (stack.isEmpty()) {
                    return 0;
                }
                
                Character top = stack.pop();
                if (pairMap.get(top) != charAt) {
                    return 0;
                }
            }
        }

        return (stack.isEmpty()) ? 1 : 0;
    }
}
