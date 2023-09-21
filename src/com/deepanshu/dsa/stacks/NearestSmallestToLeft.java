package com.deepanshu.dsa.stacks;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// Nearest Smallest Element

public class NearestSmallestToLeft {
    public static void main(String[] args) {
//        int[] nums = {1,3,2,4};

        int[] nums = {4,5,2,10,8};

        System.out.println(NSToLeft(nums));
    }

    public static List<Integer> NSToLeft(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (stack.isEmpty()) {
                list.add(-1);
            } else if (stack.peek() < nums[i]) {
                list.add(stack.peek());
            } else if (!stack.isEmpty() && stack.peek() >= nums[i]) {
                while (!stack.isEmpty() && stack.peek() >= nums[i]) {
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

        return list;
    }
}
