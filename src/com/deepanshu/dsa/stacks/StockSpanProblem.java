package com.deepanshu.dsa.stacks;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//Using a generic class to have a key-value to be used in the stack
class KeyValuePair <K,V> {
    private K key;
    private V value;

    public KeyValuePair(K key,V value) {
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


public class StockSpanProblem {
    public static void main(String[] args) {
        int[] nums = {100, 80, 60, 70, 60, 75, 85};

        System.out.println(stockSpan(nums));
    }

    public static List<Integer> nglOptimized(int[] nums) {
        List<Integer> list = new ArrayList<>();
        Stack<KeyValuePair<Integer,Integer>> stack = new Stack<>();

        for (int i = 0; i < nums.length; i++) {
            if (stack.isEmpty()) {
                list.add(-1);
            } else if (stack.peek().getKey() > nums[i]) {
                list.add(stack.peek().getValue());
            } else if (!stack.isEmpty() && stack.peek().getKey() <= nums[i]) {
                while (!stack.isEmpty() && stack.peek().getKey() <= nums[i]) {
                    stack.pop();
                }

                if (stack.isEmpty()) {
                    list.add(-1);
                } else {
                    list.add(stack.peek().getValue());
                }
            }

            stack.push(new KeyValuePair<>(nums[i], i));
        }

        return list;
    }

    public static List<Integer> stockSpan(int[] nums) {
        List<Integer> list = nglOptimized(nums);

        System.out.println(list);

        for (int i = 0; i < list.size(); i++) {
            list.set(i , i - list.get(i));
        }

        return list;
    }
}
