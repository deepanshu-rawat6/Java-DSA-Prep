package com.deepanshu.dsa_practice.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {
    public static void main(String[] args) {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;
        System.out.println(combinationSum2(candidates, target));
    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
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
            for (int i = indx; i < candidates.length; i++) {
                if (i > indx && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                tempList.add(candidates[i]);
                backtrack(res, tempList, remainingTarget - candidates[i], i + 1, candidates);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
}
