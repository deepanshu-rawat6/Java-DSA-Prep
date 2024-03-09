package com.deepanshu.dsa_practice.leetcode;

public class MinimumLengthofStringAfterDeletingSimilarEnds {
    public static void main(String[] args) {
//        String s = "bbbbbbbbbbbbbbbbbbb";
        String s = "bbbbbbbbbbbbbbbbbbbbbbbbbbbabbbbbbbbbbbbbbbccbcbcbccbbabbb";
//        String s = "bbbbbbbbbbbbbbbbbbb";
//        String s = "bbbbbbbbbbbbbbbbbbb";
        System.out.println(minimumLength(s));
    }

    public static  int minimumLength(String s) {
        int i = 0, j = s.length() - 1, max = 0;

        while (i < j && s.charAt(i) == s.charAt(j)) {
            char chr = s.charAt(i);

            while (i < j && chr == s.charAt(i)) i++;
            while (i < j && chr == s.charAt(j)) j--;
        }

        max = j - i + 1;

        return Math.max(0, max);
    }
}
