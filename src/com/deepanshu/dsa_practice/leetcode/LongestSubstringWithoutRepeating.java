package com.deepanshu.dsa_practice.leetcode;

import java.util.HashMap;

public class LongestSubstringWithoutRepeating {

    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        int maxL = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            if (map.containsKey(currentChar) && map.get(currentChar) >= left) {

                left = map.get(currentChar) + 1;
            }


            map.put(currentChar, right);


            maxL = Math.max(maxL, right - left + 1);
        }

        return maxL;
    }

    public static void main(String[] args) {
        String s1 = "abcabcbb";
        System.out.println("Output 1: " + lengthOfLongestSubstring(s1));

        String s2 = "pwwkew";
        System.out.println("Output 2: " + lengthOfLongestSubstring(s2));
    }
}