package com.deepanshu.dsa_practice.leetcode;

import java.util.Map;
import java.util.TreeMap;

public class HandofStraights {
    public static void main(String[] args) {
        int[] hand = {1,2,3,6,2,3,4,7,8};
        int groupSize = 3;
        System.out.println(isNStraightHand(hand, groupSize));
    }

    public static  boolean isNStraightHand(int[] hand, int groupSize) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i : hand) {
            map.put(i, map.getOrDefault(i, 0)+1);
        }

        for (int it : map.keySet()) {
            if (map.get(it) > 0) {
                for (int i = groupSize - 1; i >= 0; --i) {
                    if (map.getOrDefault(it + i, 0) < map.get(it)) return false;
                    map.put(it + i, map.get(it + i) - map.get(it));
                }
            }
        }
        return true;
    }
}
