package com.deepanshu.dsa.binary_search;

import java.util.Arrays;

public class TwoDArrays {
    public static void main(String[] args) {

        int[][] matrix = {
                {10, 20, 30, 40},
                {15, 25, 35, 45},
                {28, 29, 37, 49},
                {33, 34, 38, 50},
        };
        int target = 37;

        long startTime = System.nanoTime();

//        System.out.println(Arrays.toString(searchMatrix(matrix, target)));

        System.out.println(Arrays.toString(binarySearch2D(matrix, target)));

        long endTime = System.nanoTime();

        System.out.println(endTime - startTime);
    }

    public static int[] searchMatrix(int[][] matrix, int target) {
        int r = 0;
        int c = matrix.length - 1;

        while (r < matrix.length && c >= 0) {
            if (matrix[r][c] == target) {
                return new int[]{r, c};
            } else if (matrix[r][c] > target) {
                c--;
            } else {
                r++;
            }
        }

        return new int[]{-1, -1};
    }

    public static int[] binarySearch(int[][] matrix, int row, int cStart, int cEnd, int target) {
        while (cStart <= cEnd) {
            int mid = cStart + (cEnd - cStart) / 2;

            if (matrix[row][mid] == target) {
                return new int[]{row, mid};
            }

            if (matrix[row][mid] < target) {
                cStart = mid + 1;
            } else {
                cEnd = mid - 1;
            }
        }

        return new int[]{-1, -1};
    }


    public static int[] binarySearch2D(int[][] matrix, int target) {
        int rows = matrix.length;
        int cols = matrix[0].length; // chances for matrix being empty so keeping a check is advised

        if (rows == 1) {
            return binarySearch(matrix, 0, 0, cols - 1, target);
        }

        int rStart = 0;
        int rEnd = rows - 1;
        int cMid = cols / 2;

//        run the loop till two rows are remaining
        while (rStart < (rEnd - 1) ) {  // while this is true it will have more than 2 rows
            int mid = rStart + (rEnd - rStart) / 2;

            if (matrix[mid][cMid] == target) {
                return new int[]{mid, cMid};
            }

            if (matrix[mid][cMid] < target) {
                rStart = mid;
            } else {
                rEnd = mid;
            }
        }

//        now we have two rows
//        check whether the target is in the col of 2 rows

        if (matrix[rStart][cMid] == target) {
            return new int[]{rStart, cMid};
        }
        if (matrix[rStart + 1][cMid] == target) {
            return new int[]{rStart + 1, cMid};
        }

//        search in 1st half
        if (target <= matrix[rStart][cMid - 1]){
            return binarySearch(matrix, rStart, 0, cMid - 1, target);
        }

//        search in 2nd half
        if (target >= matrix[rStart][cMid + 1] && target <= matrix[rStart][cols - 1]){
            return binarySearch(matrix, rStart, cMid + 1, cols - 1, target);
        }

//        search in 3rd half
        if (target <= matrix[rStart + 1][cMid - 1]){
            return binarySearch(matrix, rStart + 1, 0, cMid - 1, target);
        } else {
            return binarySearch(matrix, rStart + 1, cMid + 1, cols - 1, target);
        }
    }
}
