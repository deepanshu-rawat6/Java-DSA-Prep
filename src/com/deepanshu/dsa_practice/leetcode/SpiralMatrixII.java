package com.deepanshu.dsa_practice.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralMatrixII {
    public static void main(String[] args) {
        int n = 3;

        System.out.println(Arrays.deepToString(generateMatrix(n)));
    }

    public static int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];

        int rowB = 0, rowE = n - 1;
        int colB = 0, colE = n - 1;
        int i = 1, val = n * n;

        while (rowB <= rowE && colB <= colE && i <= val) {
            for (int j = colB; j <= colE; j++) {
                matrix[rowB][j] = i++;
            }
            rowB++;

            for (int j = rowB; j <= rowE; j++) {
                matrix[j][colE] = i++;
            }
            colE--;

            if (rowB <= rowE) {
                for (int j = colE; j >= colB; j--) {
                    matrix[rowE][j] = i++;
                }
            }
            rowE--;

            if (colB <= colE) {
                for (int j = rowE; j >= rowB; j--) {
                    matrix[j][colB] = i++;
                }
            }
            colB++;
        }

        return matrix;
    }
}
