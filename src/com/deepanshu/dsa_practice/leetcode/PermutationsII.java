package com.deepanshu.dsa_practice.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {
    public static void main(String[] args) {
        int[] nums = {1,1,2};
        System.out.println(permuteUnique(nums));
    }

    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(ans, new ArrayList<>(), nums, 0);
        return ans;
    }

    public static void backtrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int indx) {
        if (tempList.size() == nums.length) {
            list.add(new ArrayList<>(tempList));
        } else {
            for (int i = indx; i < nums.length; i++) {
                tempList.add(nums[i]);
                backtrack(list, tempList, nums, i + 1);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
