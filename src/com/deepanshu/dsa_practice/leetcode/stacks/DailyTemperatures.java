package com.deepanshu.dsa_practice.leetcode.stacks;

import java.util.*;

class PairKV <K,V> {
    private K key;
    private V value;

    public PairKV(K key,V value) {
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

public class DailyTemperatures {
    public static void main(String[] args) {
        int[] temperatures = {73,74,75,71,69,72,76,73};
//        int[] temperatures = {30,40,50,60};
//        int[] temperatures = {30,60,90};
        System.out.println(Arrays.toString(dailyTemperatures(temperatures)));
        System.out.println(Arrays.toString(dailyTemperaturesOptimized(temperatures)));
    }


    public static int[] dailyTemperatures(int[] temperatures) {
        List<Integer> list = nearestGreatestToRight(temperatures);
        int[] res = new int[temperatures.length];
        for (int i = 0; i < temperatures.length; i++) {
            if (list.get(i) != 0) {
                res[i] = list.get(i) - i;
            } else {
                res[i] = list.get(i);
            }
        }
        return res;
    }

    public static List<Integer> nearestGreatestToRight(int[] nums) {
        Stack<PairKV<Integer, Integer>> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            if (stack.isEmpty()) {
                list.add(0);
            } else if (stack.peek().getKey() > nums[i]) {
                list.add(stack.peek().getValue());
            } else if (!stack.isEmpty() && stack.peek().getKey() <= nums[i]) {
                while (!stack.isEmpty() && stack.peek().getKey() <= nums[i]) {
                    stack.pop();
                }

                if (stack.isEmpty()) {
                    list.add(0);
                } else {
                    list.add(stack.peek().getValue());
                }
            }

            stack.push(new PairKV<>(nums[i], i));
        }

        Collections.reverse(list);

        return list;
    }


    public static int[] dailyTemperaturesOptimized(int[] temperatures) {
        Stack<PairKV<Integer, Integer>> stack = new Stack<>();
        int[] res = new int[temperatures.length];

        for (int i = 0; i < temperatures.length; i++) {
            while (!stack.isEmpty() && stack.peek().getKey() < temperatures[i]) {
                int stackIndex = stack.peek().getValue();
                stack.pop();
                res[stackIndex] = i - stackIndex;
            }

            stack.push(new PairKV<>(temperatures[i], i));
        }

        return res;
    }
}
