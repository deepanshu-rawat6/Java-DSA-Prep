package com.deepanshu.dsa.dynamic_programming;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class Fibonacci {
    static int count_rec = 0, count_dp = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] dp = new long[n + 1];
        Arrays.fill(dp, -1);
        dp[1] = 1;
        dp[2] = 2;
        System.out.println(fibo(n, dp));
//        System.out.println(fiboTabulation(n));
        System.out.println(fibo_rec(n));

        System.out.println(count_rec + " -< " + count_dp);

//        System.out.println(Arrays.toString(dp));
    }

    public static int fibo_rec(int n) {
         count_rec++;

        if (n <= 1) {
            return n;
        }

        return fibo_rec(n - 1) + fibo_rec(n - 2);
    }

    public static long fibo(int n, long[] dp) {
        count_dp++;

        if (n <= 1) return dp[n] = n;
        if (dp[n] != -1) return dp[n];

        return dp[n] = fibo(n - 1, dp) + fibo(n - 2, dp);
    }

    public static int fiboTabulation(int n) {
        int a = 0, b = 1;

        if (n < 2) {
            return n;
        }

        for (int i = 2; i <= n; i++) {
            int temp = a + b;
            a = b;
            b = temp;
        }

        return b;
    }
}
