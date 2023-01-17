package com.deepanshu.practice;

import java.util.Scanner;

public class basic {
    public static void main(String[] args){
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        helper(n);
        long start = System.nanoTime();
        System.out.println(longestCommonSubsequence("ABCBDAB","BDCABA"));

    }
    public static void helper(int n) {
        int i = n;
        while (i > 1) {
            int j = i;
            while (j < n) {
                int k = 0;
                while (k < n) {
                    k = k + 2;
                }
                j = j * 2;
            }
            i = i / 2;
        }
    }
    public static int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();

        int[][] DP = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j ==0) {
                    DP[i][j] = 0;
                } else if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    DP[i][j] = DP[i - 1][j - 1] + 1;
                } else {
                    DP[i][j] = Math.max(DP[i][j - 1],DP[i - 1][j]);
                }
            }
        }
        return DP[m][n];
    }
}
