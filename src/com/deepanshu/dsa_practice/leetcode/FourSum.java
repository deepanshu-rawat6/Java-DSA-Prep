package com.deepanshu.dsa_practice.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class FourSum {
    public static void main(String[] args) {
//        int[] nums = {1,0,-1,0,-2,2};
//        int target = 0;
//        int[] nums = {2,2,2,2,2};
//        int target = 8;
//        int[] nums = {-3,-1,0,2,4,5};
//        int target = 0;
        int[] nums = {1000000000,1000000000,1000000000,1000000000};
        int target = -294967296;
        System.out.println(fourSum(nums,target));
    }

    public static List<List<Integer>> fourSum(int[] nums, int target) {
        HashSet<List<Integer>> set = new HashSet<>();

        Arrays.sort(nums);

        long sum = 0;

        for (int i = 0; i < nums.length; i++) {
            for (int l = nums.length - 1; l >= 0; l--) {
                int j = i + 1, k = l - 1;
                while (j < k) {
                    sum = (long)nums[i] + nums[j] + nums[k] + nums[l];
                    if (sum == target) {
                        set.add(Arrays.asList(nums[i] ,nums[j] ,nums[k] ,nums[l]));
                        j++;
                        k--;
                    } else if (sum > target) {
                        k--;
                    } else {
                        j++;
                    }
                }
            }
        }

        List<List<Integer>> list = new ArrayList<>(set);

        return list;
    }
}

//Decomposing K Sum problem into 2 Sum problem

//public class Solution {
//    int len = 0;
//    public List<List<Integer>> fourSum(int[] nums, int target) {
//        len = nums.length;
//        Arrays.sort(nums);
//        return kSum(nums, target, 4, 0);
//    }
//    private ArrayList<List<Integer>> kSum(int[] nums, int target, int k, int index) {
//        ArrayList<List<Integer>> res = new ArrayList<List<Integer>>();
//        if(index >= len) {
//            return res;
//        }
//        if(k == 2) {
//            int i = index, j = len - 1;
//            while(i < j) {
//                //find a pair
//                if(target - nums[i] == nums[j]) {
//                    List<Integer> temp = new ArrayList<>();
//                    temp.add(nums[i]);
//                    temp.add(target-nums[i]);
//                    res.add(temp);
//                    //skip duplication
//                    while(i<j && nums[i]==nums[i+1]) i++;
//                    while(i<j && nums[j-1]==nums[j]) j--;
//                    i++;
//                    j--;
//                    //move left bound
//                } else if (target - nums[i] > nums[j]) {
//                    i++;
//                    //move right bound
//                } else {
//                    j--;
//                }
//            }
//        } else{
//            for (int i = index; i < len - k + 1; i++) {
//                //use current number to reduce ksum into k-1sum
//                ArrayList<List<Integer>> temp = kSum(nums, target - nums[i], k-1, i+1);
//                if(temp != null){
//                    //add previous results
//                    for (List<Integer> t : temp) {
//                        t.add(0, nums[i]);
//                    }
//                    res.addAll(temp);
//                }
//                while (i < len-1 && nums[i] == nums[i+1]) {
//                    //skip duplicated numbers
//                    i++;
//                }
//            }
//        }
//        return res;
//    }
//}
