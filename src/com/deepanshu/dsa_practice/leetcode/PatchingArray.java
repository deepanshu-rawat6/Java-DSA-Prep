package com.deepanshu.dsa_practice.leetcode;

public class PatchingArray {
    public static void main(String[] args) {
        int[] nums = {1,5,10};
        int n = 20;
        System.out.println(minPatches(nums, n));
    }

    public static int minPatches(int[] nums, int n) {
        long miss = 1;
        int added = 0, i = 0;

        while (miss <= n) {
            if (i < nums.length && nums[i] <= miss) {
                miss += nums[i++];
            } else {
                miss += miss;
                added++;
            }
        }

        return added;
    }
}
