package com.deepanshu.dsa_practice.leetcode;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        String[] strArr = {"eat","tea","tan","ate","nat","bat"};
//        String[] strArr = {""};
//        String[] strArr = {"a"};
        System.out.println(groupAnagrams(strArr));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();

        Map<String, List<String>> map = new HashMap<>();

        for (String s : strs) {
//            char[] ca = s.toCharArray();
//            Arrays.sort(ca);

            char[] ca = new char[26];
            for (char c : s.toCharArray()) {
                ca[c - 'a']++;
            }

            String keyStr = String.valueOf(ca);

            if (!map.containsKey(keyStr)) map.put(keyStr, new ArrayList<>());

            map.get(keyStr).add(s);
        }

        return new ArrayList<>(map.values());
    }
}
