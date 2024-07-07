package com.deepanshu.dsa_practice.leetcode;


import java.util.ArrayDeque;
import java.util.Deque;

public class LongestContinuousSubarrayWithAbsoluteDiffLessThanorEqualtoLimit {
    public static void main(String[] args) {
        int[] nums = {4,2,2,2,4,4,2,2};
        int limit = 0;
        System.out.println(longestSubarray(nums, limit));
    }

    public static int longestSubarray(int[] nums, int limit) {
        Deque<Integer> min_q = new ArrayDeque<>();
        Deque<Integer> max_q = new ArrayDeque<>();

        int l = 0;
        int res = 0;

        for (int i = 0; i < nums.length; i++) {
            while (!min_q.isEmpty() && nums[i] < min_q.peekLast()) {
                min_q.pollLast();
            }
            while (!max_q.isEmpty() && nums[i] > max_q.peekLast()) {
                max_q.pollLast();
            }

            min_q.add(nums[i]);
            max_q.add(nums[i]);

            while (max_q.peekFirst() - min_q.peekFirst() > limit) {
                if (nums[l] == max_q.peekFirst()) {
                    max_q.pollFirst();
                }

                if (nums[l] == min_q.peekFirst()) {
                    min_q.pollFirst();
                }

                l += 1;
            }

            res = Math.max(res, i - l + 1);
        }

        return res;
    }
}
