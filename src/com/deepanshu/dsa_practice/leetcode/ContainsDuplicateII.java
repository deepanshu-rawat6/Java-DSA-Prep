package com.deepanshu.dsa_practice.leetcode;

import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicateII {
    public static void main(String[] args) {
//        True case
//        int[] nums = {1,0,1,1};
//        int k = 1;

//        False case
//        int[] nums = {1,2};
//        int k = 2;

//        False case
        int[] nums = {1,2,3,1,2,3};
        int k = 2;
        System.out.println(containsNearbyDuplicate(nums,k));
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {

        // HashMap<Integer,Integer> map = new HashMap<>();

        // for (int i = 0; i < nums.length; i++) {
        //     if (!map.containsKey(nums[i])) {
        //         map.put(nums[i],i);
        //     } else {
        //         map.put(nums[i], Math.abs(map.get(nums[i]) - i));
        //     }
        // }

        // for (Integer val : map.values()) {
        //     if (val > k) {
        //         return false;
        //     }
        // }

        // return true;


        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; ++i) {
            if (set.contains(nums[i])) return true;
            set.add(nums[i]);
            if (set.size() > k) {
                set.remove(nums[i - k]);
            }
        }
        return false;
    }
}
