package com.deepanshu.dsa.stacks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class NearestSmallestToRight {
    public static void main(String[] args) {
        int[] nums = {1,3,2,4};

        System.out.println(NSToRight(nums));
    }

    public static List<Integer> NSToRight(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        for (int i = nums.length - 1; i >= 0; i--) {
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

        Collections.reverse(list);

        return list;
    }
}
