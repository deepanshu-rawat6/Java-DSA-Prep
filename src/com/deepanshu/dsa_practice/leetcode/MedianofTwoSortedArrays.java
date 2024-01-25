package com.deepanshu.dsa_practice.leetcode;
public class MedianofTwoSortedArrays {
    public static void main(String[] args) {
        int[] nums1 = {1,2};
        int[] nums2 = {3,4};
        System.out.println(findMedianSortedArrays(nums1, nums2));
    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0, j = 0, k = 0;
        int m = nums1.length, n = nums2.length;
        int[] merged = new int[m + n];
        while(i < m && j < n){
            if(nums1[i] < nums2[j]){
                merged[k] = nums1[i];
                i++;
            }else{
                merged[k] = nums2[j];
                j++;
            }
            k++;
        }
        while(i < m){
            merged[k] = nums1[i];
            k++;
            i++;
        }
        while(j < n){
            merged[k] = nums2[j];
            k++;
            j++;
        }

        return (((m + n) & 1) == 0) ? (double)(merged[(m + n)/2] + merged[(m + n)/2 - 1])/2 : (double) merged[(m + n)/2];
    }
}
