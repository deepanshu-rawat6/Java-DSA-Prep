package com.deepanshu.dsa_practice.leetcode;

import java.util.Arrays;

public class SpiralMatrixIII {
    public static void main(String[] args) {
        int rows = 1, cols = 4, rStart = 0, cStart = 0;

        System.out.println(Arrays.deepToString(spiralMatrixIII(rows, cols, rStart, cStart)));
    }

    public static int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) {
        int[][] directions = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int[][] result = new int[rows * cols][2];
        int steps = 0, d = 0;

        result[0] = new int[]{rStart, cStart};
        int count = 1;

        while (count < rows * cols) {
            if (d == 0 || d == 2) steps++;

            for (int i = 0; i < steps; i++) {
                rStart += directions[d][0];
                cStart += directions[d][1];

                if (rStart >= 0 && rStart < rows && cStart >= 0 && cStart < cols) {
                    result[count++] = new int[]{rStart, cStart};
                }

                if (count == rows * cols) return result;
            }

            d = (d + 1) % 4;
        }

        return result;
    }
}
