package com.deepanshu.dsa.dynamic_programming;

public class KnapsackProblem {

    public static void main(String[] args) {
        int[] wts = {5, 2, 1, 8, 7, 3};
        int[] cost = {5, 8, 9, 1, 9, 6};
        int W = 12;

        System.out.println(computeKnapsack(W, wts, cost, cost.length));
    }

    public static int computeKnapsack(int W, int[] wts, int[] cost, int n) {
        if (n == 0 || W == 0) return 0;

        if (wts[n - 1] > W) return computeKnapsack(W, wts, cost, n - 1);
        else
            return Math.max(
                    cost[n - 1] + computeKnapsack(W - wts[n - 1], wts, cost, n - 1),
                    computeKnapsack(W, wts, cost, n - 1));
    }
}
