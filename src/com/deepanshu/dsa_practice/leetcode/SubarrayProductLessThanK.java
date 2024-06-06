package com.deepanshu.dsa_practice.leetcode;

public class SubarrayProductLessThanK {
    public static void main(String[] args) {
        int[] nums = {10,5,2,6};
        int k = 100;

        System.out.println(numSubarrayProductLessThanK(nums, k));
    }

    public static int numSubarrayProductLessThanK(int[] nums, int k) {
        int res = 0, l = 0, prod = 1;
        for (int r = 0; r < nums.length; r++) {
            prod *= nums[r];
            while (l <= r && prod >= k) {
                prod = prod / nums[l];
                l += 1;
            }
            res += (r - l  + 1);
        }

        return res;
    }
}
