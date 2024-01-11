package com.deepanshu.dsa_practice.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class ContainsDuplicate {
    public static void main(String[] args) {
//        int[] arr = {1, 2, 3 , 1};
//        int[] arr = {1,2,3,4};
//        int[] arr = {1,1,1,3,3,4,3,2,4,2};
        int[] arr = {3, 3};


        System.out.println(containsDuplicate(arr));
    }

    public static boolean containsDuplicate(int[] nums) {

//        Hashing with arrays: This fails at negative numbers!


//        int[] arr = new int[100000];
//        Arrays.fill(arr, 0);
//
//        for (int num : nums) {
//            arr[num]++;
//        }
//
//        for (int num : arr) {
//            if (num > 1) {
//                return true;
//            }
//        }
//
//        return false;


//        Sorting?

//        Arrays.sort(nums);
//
//        for (int i = 1; i < nums.length; i++) {
//            if (nums[i] == nums[i - 1]) {
//                return true;
//            }
//        }
//
//        return false;

//        AC: But TC is bad( O(N log N) )

//        Hashing structures : Collection framework => HashSet

//        HashSet<Integer> set = new HashSet<>();
//
//        for(int num : nums) {
//            if (set.contains(num)) {
//                return true;
//            }
//            set.add(num);
//        }
//
//        return false;

//        AC: But time is good ( O (N) ) but now too much space is consuming

//         Hashing structures : Collection framework => HashMap

//        HashMap<Integer, Integer> map = new HashMap<>();
//
//        for (int num : nums) {
//            if (map.containsKey(num)) {
//                map.put(num, map.get(num) + 1);
//                if (map.get(num) > 1) {
//                    return true;
//                }
//            }
//            map.put(num, 1);
//        }
//
//        return false;

//        AC : But similar to prev

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int num : nums) {
            if (map.containsKey(num) && map.get(num) >= 1) {
                return true;
            }
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        return false;

//        AC : But time is O(N) but some steps require more time to execute, but space is better
    }
}
