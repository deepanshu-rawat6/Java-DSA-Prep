package com.deepanshu.dsa_practice.leetcode;

import java.util.*;

public class TopKFrequentElements {

    public static void main(String[] args) {
        int[] nums = {1,1,1,2,2,3};
        int k = 2;
        System.out.println(Arrays.toString(topKFrequent(nums, k)));
    }

//    public static int[] topKFrequent(int[] nums, int k) {
//        int[] arr = new int[k];
//        HashMap<Integer, Integer> map = new HashMap<>();
//        for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);
//        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>(
//                (a, b) ->
//                        a.getValue() - b.getValue()
//        );
//        for (Map.Entry<Integer, Integer> it : map.entrySet()) {
//            pq.add(it);
//            if (pq.size() > k) pq.poll();
//        }
//        int i = k;
//        while (!pq.isEmpty()) {
//            arr[--i] = pq.poll().getKey();
//        }
//        return arr;
//    }

    public static int[] topKFrequent(int[] nums, int k) {
        int[] arr = new int[k];
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums) map.put(num, map.getOrDefault(num, 0) + 1);

        PriorityQueue<Map.Entry<Integer,Integer>> maxHeap = new PriorityQueue<>(
                (a,b) -> b.getValue() - a.getValue()
        );

        maxHeap.addAll(map.entrySet());

        int i = 0;
        while (i < k) {
            arr[i++] = Objects.requireNonNull(maxHeap.poll()).getKey();
        }

        return arr;
    }
}
