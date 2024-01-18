package com.deepanshu.dsa_practice.leetcode;

import java.util.Arrays;
import java.util.HashSet;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] nums = {100, 4, 200, 1, 3, 2};
//        int[] nums = {0,3,7,2,5,8,4,6,0,1};
//        int[] nums = {0,3,7,2,5,8,4,6,0,1};
//        int[] nums = {1,2,0,1};
//        int[] nums = {0};
//        int[] nums = {0, 0};
//        int[] nums = {9,1,4,7,3,-1,0,5,8,-1,6};
        System.out.println(longestConsecutive(nums));
    }
    public static int longestConsecutive(int[] nums) {
//        if (nums.length == 0) {
//            return 0;
//        }
//        int c = 1, temp = 1;
//        Arrays.sort(nums);
//        System.out.println(Arrays.toString(nums));
//        for (int i = 1; i < nums.length; i++) {
//            c = Math.max(c, temp);
//            if (nums[i - 1] + 1 == nums[i]) {
//                temp++;
//            } else {
//                temp = 1;
//            }
//        }
//        return c;

        int best = 0, y = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (Integer num : set) {
            if (!set.contains(num - 1)) {
                y = num + 1;
                while (set.contains(y)) {
                    y++;
                }
                best = Math.max(best, y - num);
            }
        }

        return best;
    }
}
