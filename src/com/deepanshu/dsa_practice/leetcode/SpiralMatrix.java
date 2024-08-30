package com.deepanshu.dsa_practice.leetcode;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};

        System.out.println(spiralOrder(matrix));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();

        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return new ArrayList<>();
        }

        int rowB = 0, rowE = matrix.length - 1;
        int colB = 0, colE = matrix[0].length - 1;

        while (rowB <= rowE && colB <= colE) {
            for (int j = colB; j <= colE; j++) {
                res.add(matrix[rowB][j]);
            }
            rowB++;

            for (int j = rowB; j <= rowE; j++) {
                res.add(matrix[j][colE]);
            }
            colE--;

            if (rowB <= rowE) {
                for (int j = colE; j >= colB; j--) {
                    res.add(matrix[rowE][j]);
                }
            }
            rowE--;

            if (colB <= colE) {
                for (int j = rowE; j >= rowB; j--) {
                    res.add(matrix[j][colB]);
                }
            }
            colB++;
        }

        return res;
    }
}
