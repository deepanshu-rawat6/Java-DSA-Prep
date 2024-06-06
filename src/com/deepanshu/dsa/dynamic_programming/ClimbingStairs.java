package com.deepanshu.dsa.dynamic_programming;

import java.util.Arrays;
import java.util.Scanner;

public class ClimbingStairs {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
//        System.out.println(climbStairsRec(n));
//        System.out.println(climbStairs(n , dp));
        System.out.println(infiniteJumps(n, 0));
    }

    public static int climbStairsRec(int n) {
        if (n < 3) {
            return n;
        }
        return climbStairsRec(n - 1) + climbStairsRec(n - 2) + climbStairsRec(n - 3);
    }

    

    public static int climbStairs(int n, int[] dp) {
        if (n == 0) return dp[n] = 1;
        if (n < 0) return 0;

        return dp[n] = climbStairs(n - 1, dp) + climbStairs(n - 2, dp) + climbStairs(n- 3, dp);
    }

    public static int infiniteJumps(int n, int ans) {
        if (n == 0) return 1;
        if (n < 0) return 0;

        for (int jump = n; n > 0; n--) {
            ans += infiniteJumps(n - jump, ans);
        }

        return ans;
    }
}
