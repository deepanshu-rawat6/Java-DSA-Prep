package com.deepanshu.dsa_practice.leetcode;

import java.util.Arrays;

public class SortColors {
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void sortColors(int[] arr) {
        int low = 0, mid = 0, high = arr.length - 1;
        while (mid <= high) {
            if (arr[mid] == 0) {
                swap(arr, low, mid);
                low++;
                mid++;
            } else if (arr[mid] == 1) {
                mid++;
            } else {
                swap(arr, mid, high);
                high--;
            }
        }
    }

    public static void main(String[] args) {
//        int[] arr = {1, 0, 2};
        int[] arr = {2, 0, 1};
        sortColors(arr);
        System.out.println(Arrays.toString(arr));
    }
}
