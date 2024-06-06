package com.deepanshu.dsa_practice.leetcode;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {
    public static void main(String[] args) {
        String s = "aab";
        System.out.println(partition(s));
    }

    private static List<List<String>> partition(String s) {
        if (s == null || s.isEmpty()) {
            return new ArrayList<>();
        }

        List<List<String>> result = new ArrayList<>();
        helper(s, new ArrayList<>(), result);
        return result;
    }

    private static void helper(String s, List<String> tempList, List<List<String>> result) {
        if (s == null || s.isEmpty()) {
            result.add(new ArrayList<>(tempList));
            return;
        }

        for (int i = 1; i <= s.length(); i++) {
            String temp = s.substring(0, i);

            if (!isPalindrome(temp)) continue;

            tempList.add(temp);
            helper(s.substring(i), tempList, result);
            tempList.remove(tempList.size() - 1);
        }
        return;
    }

    private static boolean isPalindrome(String s) {
        int l = 0, r = s.length() - 1;

        while (l <= r) {
            if (s.charAt(l) != s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
}
