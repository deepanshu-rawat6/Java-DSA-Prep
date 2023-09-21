package com.deepanshu.dsa.stacks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

//Nearest Largest Element

public class NearestLargestToRight {
    public static void main(String[] args) {
        int[] nums = {1,3,2,4};

        System.out.println(NGtoRight(nums));
    }

    public static List<Integer> NGtoRight(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();

        for (int i = nums.length - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                list.add(-1);
            } else if (stack.peek() > nums[i]) {
                list.add(stack.peek());
            } else if (!stack.isEmpty() && stack.peek() <= nums[i]) {
                while (!stack.isEmpty() && stack.peek() <= nums[i]) {
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
