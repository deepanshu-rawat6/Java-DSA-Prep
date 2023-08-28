package com.deepanshu.dsa_practice.leetcode;

public class SplitArrayLargestSum {
    public static void main(String[] args) {
//        int[] arr = {7, 2, 5, 10, 8};
        int[] arr = {1,2,3,4,5};
        System.out.println(splitArray(arr, 1));
    }

    public static int splitArray(int[] nums, int k) {
        int start = 0;
        int end = 0;

        for (int i = 0; i < nums.length; i++) {
            start = Math.max(start, nums[i]); // in the end, we will get the max element in the array
            end += nums[i]; // in the end, we will get the sum of all the elements in the array
        }

        return binarySearch(nums, start, end, k);
    }

    public static int binarySearch(int[] nums, int start, int end, int m) {
        while (start < end) {
//            try for the middle as potential ans
            int mid = start + (end - start) / 2;

//            calculate how many pieces you can divide this in with this max sum
            int sum = 0;
            int pieces = 1;
            for (int num : nums) {
                if (sum + num > mid) {
//                    you cannot add this in this subarray, make a new one
//                    say you add this num in new subarray, then sum = num
                    sum = num;
                    pieces++;
                } else {
                    sum += num;
                }
            }

            if (pieces > m) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return end;
    }
}

