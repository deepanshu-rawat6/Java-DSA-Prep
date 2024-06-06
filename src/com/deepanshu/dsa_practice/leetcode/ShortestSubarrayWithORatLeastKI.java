package com.deepanshu.dsa_practice.leetcode;

import java.util.Arrays;

public class ShortestSubarrayWithORatLeastKI {
    public static void main(String[] args) {
        int[] nums = {32,2,24,1};
        int k = 35;
        System.out.println(minimumSubarrayLength(nums, k));
    }

    public static int minimumSubarrayLength(int[] nums, int k) {
        if (maximumArr(nums) >= k) {
            return 1;
        } else {
            int tempVal = 0, l = 0, res = Integer.MAX_VALUE;
            for (int r = 0; r < nums.length; r++) {
                tempVal |= nums[r];
                res = Math.min(res, r - l + 1);
            }
            return res;
        }
    }

    public static int maximumArr(int[] nums) {
        int max = Integer.MIN_VALUE;
        for (int i : nums ) {
            if (max < i) {
                max = i;
            }
        }
        return max;
    }
}
