package com.deepanshu.dsa.dynamic_programming;

import java.util.Arrays;
import java.util.Scanner;

public class GridUniquePaths {
    public static void main(String[] args) {
        int m, n;
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();

        int[][] DP = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                DP[i][j] = -1;
            }
        }

        System.out.println(Arrays.deepToString(DP));
//        System.out.println(pathRec(m, n));

//        System.out.println(pathMemo(m - 1, n - 1, DP));

        System.out.println(mazePath(m - 1, n - 1, DP));
        System.out.println(Arrays.deepToString(DP));
    }

    public static int pathRec(int m, int n) {
        System.out.println("Row : " + m + " Col: " + n);
        if (m == 1 || n == 1) {
            return 1;
        }

        return pathRec(m - 1, n) + pathRec(m, n - 1) + pathRec(m - 1, n - 1);
    }

    public static int pathMemo(int m, int n, int[][] DP) {
        System.out.println("Row : " + m + " Col: " + n);
        if (m == 1 || n == 1) {
            return DP[m][n] = 1;
        }

        if (DP[m][n] == -1) {
            DP[m][n] = pathMemo(m - 1, n, DP) + pathMemo(m, n - 1, DP) + pathMemo(m - 1, n - 1, DP);
        }

        return DP[m][n];
    }

    public static int mazePath(int r, int c, int dp[][]) {
        if (r == 0 && c == 0) return dp[r][c] = 1;
        if (r < 0 || c < 0) return 0;

        if (dp[r][c] != -1) {
            return dp[r][c];
        }

        int h = mazePath(r, c - 1, dp);
        int v = mazePath(r - 1, c, dp);
        int d = mazePath(r - 1, c - 1, dp);

        return dp[r][c] = h + v + d;
    }
}
