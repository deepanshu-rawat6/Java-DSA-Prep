package com.deepanshu.dsa_practice.leetcode.hashtable;

import java.util.HashMap;

public class CountElementsWithMaximumFrequency {
    public static void main(String[] args) {
        int[] nums = {1,2,2,3,1,4};
//        int[] nums = {1,2,3,4,5};
//        int[] nums = {15};
        System.out.println(maxFrequencyElements(nums));
    }

    public static int maxFrequencyElements(int[] nums) {
//        int[] countArr = new int[101];
//        int maxFreq = 0, countEle = 0;
//
//        for (int num : nums) {
//            countArr[num]++;
//            maxFreq = Math.max(maxFreq, countArr[num]);
//        }
//
//        for (int i = 1; i < 101; i++) {
//            if (countArr[i] == maxFreq) {
//                countEle += countArr[i];
//            }
//        }
//
//        return countEle;

        HashMap<Integer, Integer> map = new HashMap<>();
        int maxFreq = 0, countEle = 0;

        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
            maxFreq = Math.max(map.get(num), maxFreq);
        }

        for (Integer val : map.values()) {
            if (val == maxFreq) {
                countEle += maxFreq;
            }
        }

        return countEle;
    }
}
