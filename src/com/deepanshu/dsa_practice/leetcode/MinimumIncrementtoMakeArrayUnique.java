package com.deepanshu.dsa_practice.leetcode;

import java.util.Arrays;

public class MinimumIncrementtoMakeArrayUnique {
    public static void main(String[] args) {
        int[] nums = {3,2,1,2,1,7};
        System.out.println(minIncrementForUnique(nums));
    }

    public static int minIncrementForUnique(int[] nums) {
       Arrays.sort(nums);

       int res = 0, need = 0;
       for (int i : nums) {
           res += Math.max(need - i, 0);
           need = Math.max(i, need) + 1;
       }

       return res;
    }
}
