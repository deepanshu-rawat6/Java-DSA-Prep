package com.deepanshu.dsa_practice.leetcode;

public class BestTimetoBuyandSellStock {
    public static void main(String[] args) {
        int[] prices = {2,1,2,1,0,1,2};
        System.out.println(maxProfit(prices));
    }

    public static  int maxProfit(int[] prices) {
        int l = 0, max_profit = 0;

        for (int r = 1; r < prices.length; r++) {
            int temp_profit = prices[r] - prices[l];
            while (temp_profit < 0) {
                l += 1;
                temp_profit = prices[r] - prices[l];
            }
            max_profit = Math.max(max_profit, temp_profit);
        }

        return max_profit;
    }
}
