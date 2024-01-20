package com.deepanshu.dsa_practice.leetcode;

import java.util.Arrays;

public class Searcha2DMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,3,5,7},
                {10,11,16,20},
                {23,30,34,60}
        };
        int target = 13;
        System.out.println(searchMatrix(matrix, target));
    }
    public static boolean searchMatrix(int[][] matrix, int target) {
        int ROWS = matrix.length, COLS = matrix[0].length;

        int rStart = 0, rEnd = ROWS - 1;
        while (rStart <= rEnd) {
            int rMid = rStart + (rEnd - rStart) / 2;
            if (target > matrix[rMid][COLS - 1]) {
                rStart = rMid + 1;
            } else if (target < matrix[rMid][0]) {
                rEnd = rMid - 1;
            } else {
                break;
            }
        }
        if (!(rStart <= rEnd)) {
            return false;
        }

        int correctRow = rStart + (rEnd - rStart) / 2;
        int low = 0, high = COLS - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (target > matrix[correctRow][mid]) {
                low = mid + 1;
            } else if (target < matrix[correctRow][mid]) {
                high = mid - 1;
            } else {
                return true;
            }
        }

        return false;
    }
}
