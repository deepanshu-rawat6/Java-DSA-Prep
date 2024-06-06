package com.deepanshu.dsa_practice.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class FindCommonCharacters {
    public static void main(String[] args) {
        String[] words = {"bella","label","roller"};
        System.out.println(commonChars(words));
    }

    public static List<String> commonChars(String[] words) {
        List<String> res = new ArrayList<>();

        int[] charCount = new int[26];
        Arrays.fill(charCount, Integer.MAX_VALUE);

        for (String str : words) {
            int[] charStrCount = new int[26];

            for (char chr : str.toCharArray()) {
                charStrCount[chr - 'a']++;
            }

            for (int i = 0; i < 26; i++) {
                charCount[i] = Math.min(charCount[i], charStrCount[i]);
            }
        }

//        System.out.println(Arrays.toString(charCount));

        for (char chr = 'a'; chr <= 'z'; chr++) {
            while (charCount[chr  - 'a']-- > 0) {
                res.add("" + chr);
            }
        }

        return res;
    }
}
