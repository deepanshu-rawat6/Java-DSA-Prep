package com.deepanshu.dsa_practice.leetcode;

public class FindFirstandLastPositionofElementinSortedArray {
    public static void main(String[] args) {
        int[] nums = {5,7,7,8,8,10};
        int target  = 7;
        int[] ans = searchRange(nums, target);
        System.out.println(ans[0] + " " + ans[1]);
    }

    private static int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};
        ans[0] = findUsingBinarySearch(nums, target, true);
        if (ans[0] != -1) {
            ans[1] = findUsingBinarySearch(nums, target, false);
        }
        return ans;
    }

    private static int findUsingBinarySearch(int[] nums, int target, boolean firstIndex) {
        int s = 0;
        int e = nums.length - 1;
        int ans = -1;

        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (nums[mid] > target) {
                e = mid - 1;
            } else if (nums[mid] < target) {
                s = mid + 1;
            } else {
                ans = mid;
                if (firstIndex) {
                    e = mid - 1;
                } else {
                    s = mid + 1;
                }
            }
        }

        return ans;
    }
}
