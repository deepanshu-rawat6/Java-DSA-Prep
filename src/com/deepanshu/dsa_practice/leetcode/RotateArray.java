package com.deepanshu.dsa_practice.leetcode;

import java.util.Arrays;
import java.util.Scanner;

public class RotateArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums = {1,2,3,4,5};
        int k = 2;
        rotate(nums, k);

        System.out.println(Arrays.toString(nums));
    }
    public static void rotate(int[] nums, int k) {
        int len = nums.length;
        k %= len;

        reverseArr(nums, 0, len - 1);
        reverseArr(nums, 0, k - 1);
        reverseArr(nums, k, len - 1);
    }

    private static void reverseArr(int[] nums, int l, int r) {
        while (l <= r) {
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
            l++;
            r--;
        }
    }
}