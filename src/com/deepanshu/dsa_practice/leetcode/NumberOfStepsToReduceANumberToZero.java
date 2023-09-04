package com.deepanshu.dsa_practice.leetcode;

public class NumberOfStepsToReduceANumberToZero {
    public static void main(String[] args) {
        System.out.println(numberOfSteps(8));
        System.out.println(numberOfSteps(14));
    }

    public static int numberOfSteps(int num) {
        return helper(num,0);
    }

    public static int helper(int num, int steps) {
        if (num == 0) return steps;
        if (num % 2 == 0) return helper(num / 2, steps + 1);
        else return helper(num - 1, steps + 1);
    }
}
