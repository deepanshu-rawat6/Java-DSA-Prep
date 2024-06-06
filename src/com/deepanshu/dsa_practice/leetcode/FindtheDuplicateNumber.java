package com.deepanshu.dsa_practice.leetcode;

public class FindtheDuplicateNumber {
    public static void main(String[] args) {
        int[] nums = {1,3,4,2,2};
        System.out.println(findDuplicate(nums));
    }

    public static int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;

        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        int head = 0;
        do {
            slow = nums[slow];
            head = nums[head];
        } while (slow != head);

        return slow;
    }
}
