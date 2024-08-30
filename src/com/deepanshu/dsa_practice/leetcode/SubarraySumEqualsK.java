package com.deepanshu.dsa_practice.leetcode;

import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {
    public static void main(String[] args) {
        int[] nums1 = {1, 1, 1};
        int k1 = 2;
        System.out.println(subarraySum(nums1, k1));

        int[] nums2 = {1, 2, 3};
        int k2 = 3;
        System.out.println(subarraySum(nums2, k2));
    }

    public static int subarraySum(int[] nums, int k) {
        int res = 0;
        int preSum = 0;
        Map<Integer, Integer> sumC = new HashMap<>();
        sumC.put(0, 1);

        for (int num : nums) {
            preSum += num;


            if (sumC.containsKey(preSum - k)) {
                res += sumC.get(preSum - k);
            }

            sumC.put(preSum, sumC.getOrDefault(preSum, 0) + 1);
        }

        return res;
    }
}
