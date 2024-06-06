package com.deepanshu.dsa_practice.practice;

import java.util.Scanner;

public class REACH_NTH_STAIR {

    private static final long MOD = 1000000007;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while ( t != 0) {
            int x = sc.nextInt();
            System.out.println(solve(x));
            t--;
        }
    }

    public static int solve(int x) {
        long[] dp = new long[x + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= x; i++) {
            dp[i] = dp[i - 1];
            dp[i] = (dp[i] + dp[i - 2]) % MOD;
        }

        return (int) dp[x];
    }
}
