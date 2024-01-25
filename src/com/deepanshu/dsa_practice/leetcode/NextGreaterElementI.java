package com.deepanshu.dsa_practice.leetcode;

import java.util.*;

public class NextGreaterElementI {
    public static void main(String[] args) {
        int[] nums1 = {4,1,2};
        int[] nums2 = {1,3,4,2};
        System.out.println(Arrays.toString(nextGreaterElement(nums1, nums2)));
    }
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        List<Integer> list = NearestGreatestToRight(nums2);
        HashMap<Integer, Integer> map = new HashMap<>();

        int[] result = new int[nums1.length];

        for (int i = 0; i < nums2.length; i++) {
            map.put(nums2[i], list.get(i));
        }

        for (int i = 0 ; i < nums1.length; i++) {
            result[i] = map.get(nums1[i]);
        }

        return result;
    }

    public static List<Integer> NearestGreatestToRight(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = nums.length - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                list.add(-1);
            } else if (stack.peek() > nums[i]) {
                list.add(stack.peek());
            } else if (!stack.isEmpty() && stack.peek() < nums[i]) {
                while (!stack.isEmpty() && stack.peek() < nums[i]) {
                    stack.pop();
                }

                if (stack.isEmpty()) {
                    list.add(-1);
                } else {
                    list.add(stack.peek());
                }
            }

            stack.add(nums[i]);
        }

        Collections.reverse(list);

        return list;
    }
}
