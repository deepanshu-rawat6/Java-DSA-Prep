package com.deepanshu.dsa_practice.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class TwoSumII_InputArrayIsSorted {
    public static void main(String[] args) {
//        int[] nums = {2,7,11,15};
//        int target = 9;

//        int[] nums = {2,3,4};
//        int target = 6;

//        int[] nums = {-1,0};
//        int target = -1;

//        int[] nums = {5,24,50,79,88,150,345};
//        int target = 200;


        int[] nums = {1,2,3,4,4,9,56,90};
        int target = 8;


//        System.out.println(Arrays.toString(twoSum(nums, target)));

//        System.out.println(Arrays.toString(twoSumBS(nums, target)));

        System.out.println(Arrays.toString(twoSumHashMap(nums, target)));
    }

    public static int[] twoSum(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int temp = nums[i] + nums[j];
            if (temp == target) {
                return new int[]{i + 1, j + 1};
            } else if (temp > target) {
                j--;
            } else  {
                i++;
            }
        }
        return new int[]{-1,-1};
    }

    public static int[] twoSumBS(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            int start = i + 1;
            int end = nums.length - 1;
            while (start <= end) {
                int mid = start + (end - start) / 2;
                int temp = target - nums[i];
                if (nums[mid] == temp) {
                    return new int[] {i + 1, mid + 1};
                } else if (nums[mid] > temp) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            }
        }

        return new int[]{-1, -1};
    }

    public static int[] twoSumHashMap(int[] nums, int target) {
        HashMap<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) return new int[] {map.get(target - nums[i]), i + 1};
            map.putIfAbsent(nums[i], i + 1);
        }

        return new int[] {-1,-1};
    }
}
