package com.deepanshu.dsa_practice.leetcode.prefixSum;

import java.util.HashMap;

public class ContiguousArray {
    public static void main(String[] args) {
        int[] nums = {0, 1, 1, 0};
        System.out.println(findMaxLength(nums));
    }
    public static int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int maxLen = 0, preSum = 0;
        map.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                preSum += 1;
            } else {
                preSum -= 1;
            }

            if (map.containsKey(preSum)) {
                maxLen = Math.max(maxLen, i - map.get(preSum));
            } else {
                map.put(preSum, i);
            }
        }

        return maxLen;
    }
}
