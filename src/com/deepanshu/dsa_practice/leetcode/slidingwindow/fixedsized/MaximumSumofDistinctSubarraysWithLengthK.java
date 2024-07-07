package com.deepanshu.dsa_practice.leetcode.slidingwindow.fixedsized;

import java.util.HashMap;

public class MaximumSumofDistinctSubarraysWithLengthK {
    public static void main(String[] args) {
        int[] nums = {1,5,4,2,9,9,9};
        int k = 3;
        System.out.println(maximumSubarraySum(nums, k));
    }

    public static long maximumSubarraySum(int[] nums, int k) {
        long sumMax = 0, tempSum = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        int i = 0, j = 0;
        while (j < nums.length) {
            tempSum += nums[j];
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);

            if (j - i + 1 == k) {
                if (map.size() == k) {
                    sumMax = Math.max(sumMax, tempSum);
                }
                tempSum -= nums[i];
                map.put(nums[i], map.get(nums[i]) - 1);
                if (map.get(nums[i]) == 0) {
                    map.remove(nums[i]);
                }
                i++;
            }
            j++;
        }

        return sumMax;
    }
}
