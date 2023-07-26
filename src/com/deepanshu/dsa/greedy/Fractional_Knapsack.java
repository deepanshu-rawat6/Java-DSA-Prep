package com.deepanshu.dsa.greedy;

import java.util.Arrays;

public class Fractional_Knapsack {
    public static void main(String[] args) {
        int[][] arr = {{60, 10}, {100, 20}, {120, 30}};
        System.out.println(maxprofit(arr,50));
    }
    public static int maxprofit(int[][] weighs,int capacity) {
        Arrays.sort(weighs, (x, y) -> Double.compare((double) y[1]/y[0], (double) x[1]/x[0]));
        int max_profit = 0;
        System.out.println(Arrays.toString(weighs));
        return max_profit;
    }
}
