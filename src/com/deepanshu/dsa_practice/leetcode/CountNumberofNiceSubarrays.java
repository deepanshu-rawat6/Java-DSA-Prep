package com.deepanshu.dsa_practice.leetcode;

public class CountNumberofNiceSubarrays {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 1, 1};
        int k = 3;
        System.out.println(numberOfSubarrays(nums, k));
    }

    public static int numberOfSubarrays(int[] nums, int k) {
        int res = 0, i = 0, count = 0, n = nums.length;

        for (int num : nums) {
            if (num % 2 == 1) {
                --k;
                count = 0;
            }

            while (k == 0) {
                k += nums[i++] & 1;
                ++count;
            }

            res += count;
        }

        return res;
    }
}
