package com.deepanshu.dsa_practice.leetcode;

import java.util.PriorityQueue;

public class KthLargest {

    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int k = 2;

        System.out.println(findKthLargest(nums, k));
    }

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            minHeap.offer(nums[i]);
        }

        for (int i = k; i < nums.length; i++) {
            if (nums[i] > minHeap.peek()) {
                minHeap.poll();
                minHeap.offer(nums[i]);
            }
        }

        return minHeap.peek();
    }
}