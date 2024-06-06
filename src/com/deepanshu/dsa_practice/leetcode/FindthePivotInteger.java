package com.deepanshu.dsa_practice.leetcode;

public class FindthePivotInteger {
    public static void main(String[] args) {
        int n = 8;
        System.out.println(pivotInteger(n));
    }

    public static int pivotInteger(int n) {
        int tSum = 0;
        for (int i = 1; i <= n; i++) {
            tSum += i;
        }

        int preSum = 0;

        for (int i = 1; i <= n; i++) {
            preSum += i;
            if ((tSum - preSum + i) == preSum) {
                return i;
            }
        }

        return -1;
    }
}
