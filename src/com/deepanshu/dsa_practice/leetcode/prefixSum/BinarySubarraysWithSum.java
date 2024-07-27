package com.deepanshu.dsa_practice.leetcode.prefixSum;

import java.util.HashMap;

public class BinarySubarraysWithSum {
    public static void main(String[] args) {
        int[] nums = {1,0,1,0,1};
        int goal = 2;
        System.out.println(numSubarraysWithSum(nums, goal));
    }

    public static int numSubarraysWithSum(int[] nums, int goal) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int preSum = 0, count = 0;
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];
            int remove = preSum - goal;
            count += map.get(remove);
            map.getOrDefault(preSum, map.get(preSum) + 1);
        }

        return count;
    }
}
