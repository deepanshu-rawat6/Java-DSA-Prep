package com.deepanshu.dsa_practice.leetcode.strings;

import java.util.ArrayList;
import java.util.List;

public class EncodeandDecodeStrings {
    public static void main(String[] args) {
        List<String> strs = List.of(new String[]{"neet", "code", "love", "you"});
        String str = encode(strs);
        System.out.println(str);
        System.out.println(decode(str));
    }

    public static String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();

        for (String str : strs) {
            sb.append(str.length()).append('#').append(str);
        }

        return sb.toString();
    }

    public static List<String> decode(String str) {
        List<String> strs = new ArrayList<>();

        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') j++;

            int length = Integer.parseInt(str.substring(i, j));

            i = j + 1 + length;

            strs.add(str.substring(j + 1, i));
        }

        return strs;
    }
}
