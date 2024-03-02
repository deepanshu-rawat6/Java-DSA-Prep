package com.deepanshu.dsa_practice.leetcode;

import java.util.Arrays;

public class SquaresofaSortedArray {
    public static void main(String[] args) {
//        int[] nums = {-5,-3,-2,-1};
        int[] nums = {-7,-3,2,3,11};
        System.out.println(Arrays.toString(sortedSquares(nums)));
    }

    public static int[] sortedSquares(int[] nums) {
//        int[] result = new int[nums.length];
//        int i = 0, j = nums.length - 1, k = nums.length - 1;
//        while (i <= j) {
//            if (Math.abs(nums[i]) > Math.abs(nums[j])) {
//                result[k] = nums[i] * nums[i];
//                i++;
//            } else {
//                result[k] = nums[j] * nums[j];
//                j--;
//            }
//            k--;
//        }
//
//        return result;
        int n = nums.length;
        int left = 0;
        int right = n - 1;

        // Use a pointer to track the position where the positive and negative parts meet
        int mergeIndex = n - 1;

        while (left <= right) {
            int leftSquare = nums[left] * nums[left];
            int rightSquare = nums[right] * nums[right];

            if (leftSquare > rightSquare) {
                nums[mergeIndex] = leftSquare;
                left++;
            } else {
                nums[mergeIndex] = rightSquare;
                right--;
            }

            mergeIndex--;
        }
        return  nums;
    }
}
