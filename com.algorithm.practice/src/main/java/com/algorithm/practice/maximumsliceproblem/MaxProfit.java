package com.algorithm.practice.maximumsliceproblem;

public class MaxProfit {
    public int solution(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }

        int totalProfit = 0;
        int maxProfit = Integer.MIN_VALUE;
        for (int i = 1; i < prices.length; i++) {
            int profitFromPreviousDay = prices[i] - prices[i - 1]; 
            totalProfit = Math.max(profitFromPreviousDay + totalProfit, 0);
            if (totalProfit > maxProfit) {
                maxProfit = totalProfit;
            }
        }

        return maxProfit;
    }
}
