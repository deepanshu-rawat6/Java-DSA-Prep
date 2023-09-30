package com.deepanshu.dsa.stacks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

class NGindex <K,V> {
    private K key;
    private V value;

    public NGindex(K key,V value) {
        this.key = key;
        this.value = value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}

public class MaximumAreaHistogram {
    public static void main(String[] args) {
        int[] nums = {6,2,5,4,5,1,6};

        System.out.println(maxAreaHistogram(nums));
    }

    public static int maxAreaHistogram(int[] nums) {
        List<Integer> width = calculateWidth(nums);

        List<Integer> area = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            area.add(i, nums[i] * width.get(i));
        }

        return Collections.max(area);
    }

    public static List<Integer> nearestSmallestToRight(int[] nums) {
        Stack<NGindex<Integer,Integer>> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();

        for (int i = nums.length - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                list.add(nums.length);
            } else if (stack.peek().getKey() < nums[i]) {
                list.add(stack.peek().getValue());
            } else if (!stack.isEmpty() && stack.peek().getKey() >= nums[i]) {
                while (!stack.isEmpty() && stack.peek().getKey() >= nums[i]) {
                    stack.pop();
                }

                if (stack.isEmpty()) {
                    list.add(nums.length);
                } else {
                    list.add(stack.peek().getValue());
                }
            }

            stack.push(new NGindex<>(nums[i], i));
        }

        Collections.reverse(list);

        return list;
    }

    public static List<Integer> nearestSmallestToLeft(int[] nums) {
        Stack<NGindex<Integer,Integer>> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i <= nums.length - 1; i++) {
            if (stack.isEmpty()) {
                list.add(-1);
            } else if (stack.peek().getKey() < nums[i]) {
                list.add(stack.peek().getValue());
            } else if (!stack.isEmpty() && stack.peek().getKey() >= nums[i]) {
                while (!stack.isEmpty() && stack.peek().getKey() >= nums[i]) {
                    stack.pop();
                }

                if (stack.isEmpty()) {
                    list.add(-1);
                } else {
                    list.add(stack.peek().getValue());
                }
            }

            stack.push(new NGindex<>(nums[i], i));
        }

        return list;
    }

    public static List<Integer> calculateWidth(int[] nums) {
        List<Integer> width = new ArrayList<>();

        List<Integer> right = nearestSmallestToRight(nums);
        List<Integer> left = nearestSmallestToLeft(nums);

//        System.out.println(right);
//        System.out.println(left);

        for (int i = 0; i < nums.length; i++) {
            width.add(i,right.get(i) - left.get(i) - 1);
        }

//        System.out.println(width);

        return width;
    }
}
