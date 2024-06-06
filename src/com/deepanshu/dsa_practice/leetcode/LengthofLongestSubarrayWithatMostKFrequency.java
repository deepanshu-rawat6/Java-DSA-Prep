package com.deepanshu.dsa_practice.leetcode;

import java.util.HashMap;

public class LengthofLongestSubarrayWithatMostKFrequency {
    public static void main(String[] args) {
//        int[] nums = {1,2,3,1,2,3,1,2};
//        int k = 2;
//        int[] nums = {1,2,1,2,1,2,1,2};
//        int k = 1;
        int[] nums = {1, 4, 4, 3};
        int k = 1;
        System.out.println(maxSubarrayLength(nums, k));
    }

    public static int maxSubarrayLength(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int l = 0;
        int res = 0;
        for (int r = 0; r < nums.length; r++) {
            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);
            while (map.get(nums[r]) > k) {
                map.put(nums[l], map.get(nums[l]) - 1);
                l += 1;
            }
            res = Math.max(res, r - l + 1);
        }

        return res;
    }
}
