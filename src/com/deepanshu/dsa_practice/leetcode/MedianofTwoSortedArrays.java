package com.deepanshu.dsa_practice.leetcode;

import java.util.Arrays;

public class MedianofTwoSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,4,5};
        int[] nums2 = {1,2,3,5,5,6,7,8};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
//    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
//        int i = 0, j = 0, k = 0;
//        int m = nums1.length, n = nums2.length;
//        int[] merged = new int[m + n];
//        while(i < m && j < n){
//            if(nums1[i] < nums2[j]){
//                merged[k] = nums1[i];
//                i++;
//            }else{
//                merged[k] = nums2[j];
//                j++;
//            }
//            k++;
//        }
//        while(i < m){
//            merged[k] = nums1[i];
//            k++;
//            i++;
//        }
//        while(j < n){
//            merged[k] = nums2[j];
//            k++;
//            j++;
//        }
//
//        return (((m + n) & 1) == 0) ? (double)(merged[(m + n)/2] + merged[(m + n)/2 - 1])/2 : (double) merged[(m + n)/2];
//    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        if (m > n) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int total = m + n;
        int half = (total + 1) / 2;

        int left = 0;
        int right = m;

        double result = 0.0;

        while (left <= right) {
            int i = left + (right - left) / 2;
            int j =half - i;

            int left1 = (i > 0) ? nums1[i - 1] : Integer.MIN_VALUE;
            int right1 = (i < m) ? nums1[i] : Integer.MAX_VALUE;
            int left2 = (j > 0) ? nums2[j - i] : Integer.MIN_VALUE;
            int right2 = (j < n) ? nums2[j] : Integer.MAX_VALUE;

//            Partition is correct
            if (left1 <= right2 && left2 <= right1) {
                if (total % 2 == 0) {
                    result = (double) (Math.max(left1, left2) + Math.min(right1, right2)) / 2;
                } else {
                    result = Math.max(left1, left2);
                }
                break;
            } else if (left1 > left2) {
                right = i - 1;
            } else {
                left = i + 1;
            }
        }

        return  result;

    }
}
