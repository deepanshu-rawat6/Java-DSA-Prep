package com.deepanshu.dsa_practice.leetcode;


import java.util.*;

public class SortArraybyIncreasingFrequency {

    static class Pair {
        private int key;
        private int val;

        public Pair(int key, int val) {
            this.key = key;
            this.val = val;
        }

        public int getKey() {
            return key;
        }

        public int getVal() {
            return val;
        }
    }

    public static void main(String[] args) {
        int[] nums = {-1,1,-6,4,5,-6,1,4,1};


        System.out.println(Arrays.toString(frequencySort(nums)));
    }

    public static int[] frequencySort(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        List<Pair> list = new ArrayList<>();

        for (Map.Entry<Integer,Integer> entry : map.entrySet())  {
            list.add(new Pair(entry.getKey(), entry.getValue()));
        }

        list.sort((a, b) -> {
            if (a.getVal() == b.getVal()) return b.getKey() - a.getKey();
            return a.getVal() - b.getVal();
        });

        int[] res = new int[nums.length];
        int indx = 0;

        for (Pair pair : list) {
            while (pair.val != 0) {
                res[indx++] = pair.key;
                pair.val--;
            }
        }

        return res;
    }
}
