package com.deepanshu.dsa_practice.practice;

public class FirstNegative {
    public static void main(String[] args) {
        int[][] grid = {{4,3,2,-1},{3,2,1,-1},{1,1,-1,-2},{-1,-1,-2,-3}};
//        System.out.println(binary_search(arr,0,5));
        System.out.println(countNegatives(grid));
    }
    public static int countNegatives(int[][] grid) {
        int count = 0;
        int m = grid.length , n = grid[0].length;
        for (int[] ints : grid) {
            count += binary_search(ints);
        }
        return count;
    }
    public static int binary_search(int[] arr) {
        int s = 0, e = arr.length - 1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (arr[mid] >= 0) {
                s = mid + 1;
            } else {
               e = mid - 1;
            }
        }
        return arr.length - e - 1;
    }
}
