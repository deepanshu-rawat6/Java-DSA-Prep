package com.deepanshu.dsa_practice.leetcode;

public class MinimumCommonValue {
    public static void main(String[] args) {
        int[] num1 = {1,2,3};
        int[] nums2 = {2,4};
//        int[] num1 = {1,2,3,6};
//        int[] nums2 = {2,3,4,5};
        System.out.println(getCommon(num1, nums2));
    }


    public static int getCommon(int[] nums1, int[] nums2) {
        int i = 0, j = 0;
        while (i != nums1.length && j != nums2.length) {
            if (nums1[i] == nums2[j]) {
                return nums1[i];
            } else if (nums1[i] < nums2[j]) {
                i++;
            } else {
                j++;
            }
        }
        return -1;
    }

//    public static boolean helper(int[] nums, int target) {
//        int start = 0, end = nums.length - 1;
//        while (start <= end) {
//            int mid = start + (end - start) / 2;
//            if (nums[mid] == target) {
//                return true;
//            } else if (nums[mid] > target) {
//                end  = mid - 1;
//            } else {
//                start = mid + 1;
//            }
//        }
//
//        return false;
//    }
//
//    public static int getCommon(int[] nums1, int[] nums2) {
//        for (int j : nums1) {
//            if (helper(nums2, j)) {
//                return j;
//            }
//        }
//
//        return -1;
//    }
}
