package com.deepanshu.dsa_practice.leetcode.binarysearch;

public class BinarySearchRecursion {
    public static void main(String[] args) {
        int[] arr = {-1,0,3,5,10,12};
        int target = 9;
        System.out.println(search(arr, target));
    }

    public static int search(int[] nums, int target) {
        return helper(nums, 0, nums.length - 1, target);
    }

    public static int helper(int[] nums, int start, int end, int target) {
        if (start > end) {
            return -1;
        }
        int mid = start +  (end - start) / 2;
        if (nums[mid] == target) {
            return mid;
        }

        if (nums[mid] > target) {
            return helper(nums, 0, mid - 1, target);
        }
        return helper(nums, mid + 1, end, target);
    }
}
