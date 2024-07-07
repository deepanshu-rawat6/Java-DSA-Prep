package com.deepanshu.dsa_practice.leetcode.slidingwindow.fixedsized;

public class MaximumSumSubarrayOfSizeK {
    public static void main(String[] args) {
        int[] nums = {2, 5, 1, 8, 2, 9, 1};
        int k = 3;
        System.out.println(maximumSumSubarrayK(nums, k));
    }

    public static int maximumSumSubarrayK(int[] nums, int k) {
        int sumMax = 0, sum = 0;

        int i = 0, j = 0;
        while (j < nums.length) {
            sum = sum + nums[j];
            if (j - i  + 1 < k) {
                j++;
            } else if (j - i + 1 == k){
                sumMax = Math.max(sum, sumMax);
                sum -= nums[i];
                i++;
                j++;
            }
        }

        return sumMax;
    }
}
