package com.deepanshu.dsa_practice.leetcode.hashtable;

import java.util.HashMap;
import java.util.Map;

public class CustomSortString {
    public static void main(String[] args) {
        String order = "bcafg";
        String s = "abcd";
        System.out.println(customSortString(order, s));
    }

    public static String customSortString(String order, String s) {
        StringBuilder sb = new StringBuilder();
        HashMap<Character, Integer> map = new HashMap<>();

        for (char ch : s.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        for (char chr : order.toCharArray()) {
            while ((s.indexOf(chr) != -1) && map.get(chr) != 0) {
                sb.append(chr);
                map.put(chr, map.get(chr) - 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            char chr = entry.getKey();
            while (map.get(chr) != 0) {
                sb.append(chr);
                map.put(chr, map.get(chr) - 1);
            }
        }

        return sb.toString();
    }
}
