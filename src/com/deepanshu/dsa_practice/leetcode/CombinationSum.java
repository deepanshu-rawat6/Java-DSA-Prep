package com.deepanshu.dsa_practice.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSum {
    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;
        System.out.println(combinationSum(candidates, target));
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(res, new ArrayList<>(), target, 0, candidates);
        return res;
    }

    public static void backtrack(List<List<Integer>> res,List<Integer> tempList, int remainingTarget, int indx, int[] candidates) {
        if (remainingTarget < 0) return;
        if (remainingTarget == 0) {
            res.add(new ArrayList<>(tempList));
        } else {
            for (; indx < candidates.length; indx++) {
                tempList.add(candidates[indx]);
                backtrack(res, tempList, remainingTarget - candidates[indx], indx, candidates);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
