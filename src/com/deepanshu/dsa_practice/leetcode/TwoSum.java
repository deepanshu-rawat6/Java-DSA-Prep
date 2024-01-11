package com.deepanshu.dsa_practice.leetcode;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {3 , 2 ,4};
        int target = 6;
        System.out.println(Arrays.toString(twoSum(nums, target)));
    }

    public static int[] twoSum(int[] nums, int target) {
//        HashMap<Integer, Integer> map = new HashMap<>();
//            for (int i = 0; i < nums.length; i++) {
//                if (map.containsKey(target - nums[i])) {
//                    return new int[]{map.get(target - nums[i]), i};
//                }
//                map.put(nums[i], i);
//        }
//        return new int[]{-1, -1};
//    }

        int n = nums.length;

        for (int i = 1; i < n; i++) {

            for (int j = i; j < n; j++) {

                int sum = nums[j] + nums[j - i];

                if (sum == target) {
                    return new int[]{j - i, j};
                }

            }
        }

        return null;
    }
}
