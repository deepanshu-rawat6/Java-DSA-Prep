package com.deepanshu.dsa_practice.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LetterCombinationsofaPhoneNumber {

    static Map<Character, String> map = Map.of(
            '2', "abc",
            '3', "def",
            '4', "ghi",
            '5', "jkl",
            '6', "mno",
            '7', "pqrs",
            '8', "tuv",
            '9', "wxyz"
    );

    public static void main(String[] args) {
        String digits = "";
        System.out.println(letterCombinations(digits));
    }

    public static List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        if (digits.isEmpty()) {
            return new ArrayList<>();
        }
        backtrack(res, digits, "", 0);
        return res;
    }

    public static void backtrack(List<String> res, String digits, String current, int indx) {
        if (current.length() == digits.length()) {
            res.add(current);
            return;
        } else if (indx >= digits.length()) {
            return;
        } else {
            String digit = map.get(digits.charAt(indx));
            for (char chr : digit.toCharArray()) {
                backtrack(res, digits, current + chr, indx + 1);
            }
        }
    }
}
