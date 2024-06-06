package com.deepanshu.dsa_practice.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String s = "abcabcbb";
//        String s = " ";
        System.out.println(lengthOfLongestSubstring(s));
    }

    public static int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int l = 0, res = 0;

        if (s.isEmpty()) {
            return 0;
        }

        for (int r = 0; r < s.length(); r++) {
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r), 0) + 1);

            while (map.get(s.charAt(r)) > 1) {
                map.put(s.charAt(l), map.get(s.charAt(l)) - 1);
                l += 1;
            }

            res = Math.max(res, r - l + 1);
        }

        return res;

//        int[] count = new int[26];
//        int l = 0, res = 0;
//
//        if (s.isEmpty()) {
//            return res;
//        }
//
//        for (int r = 0; r < s.length(); r++) {
//            int temp = s.charAt(r) - 'a';
//            count[temp]++;
//            while (count[temp] > 1) {
//                count[s.charAt(l) - 'a']--;
//                l += 1;
//            }
//
//            res = Math.max(res, r - l + 1);
//        }
//        return res;
    }
}
