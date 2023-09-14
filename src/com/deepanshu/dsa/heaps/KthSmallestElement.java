package com.deepanshu.dsa.heaps;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthSmallestElement {
    public static void main(String[] args) {
        int[] arr = {7,10,4,3,20,15};
        int k = 3;
        System.out.println(findElement(arr,k));
        System.out.println(findElementOptimized(arr,k));
    }

//    Basic approach: Sort the array and return the kth element
//    TC: O(N log N)
    public static int findElement(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[k - 1];
    }

//    Optimized approach: Using maxHeap, to reduce time complexity to O(N log K)
//    Whenever we add a value to the heap, it will heap-ify, to make the largest element at the top
    public static int findElementOptimized(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(
                (a,b) -> b - a
        );

        for (int i : nums) {
            maxHeap.add(i);
            if (maxHeap.size() > k) {
                maxHeap.poll();
            }
        }

        return maxHeap.peek();
    }
}
