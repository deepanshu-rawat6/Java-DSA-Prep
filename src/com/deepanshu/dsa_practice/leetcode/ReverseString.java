package com.deepanshu.dsa_practice.leetcode;

import java.util.ArrayList;
import java.util.Arrays;

public class ReverseString {
    public static void main(String[] args) {
//        char[] s = {'h','e','l','l','o'};
        char[] s = {'H','a','n','n','a','h'};
        reverseString(s);
        System.out.println(Arrays.toString(s));
    }

    public static void reverseString(char[] s) {
//        helper(s, 0, s.length - 1);
        int l = 0;
        int r = s.length - 1;

        while (l <= r) {
            char temp = s[l];
            s[l++] = s[r];
            s[r--] = temp;
        }
    }

    public static void helper(char[] s, int start, int end) {
        if (start > end) {
            return;
        }

        char temp = s[start];
        s[start] = s[end];
        s[end] = temp;

        helper(s, start + 1, end - 1);
    }
}
