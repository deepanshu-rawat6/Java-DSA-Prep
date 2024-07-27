package com.deepanshu.dsa_practice.leetcode;

import java.util.Stack;

public class MaximumScoreFromRemovingSubstrings {
    static int res = 0;

    public static void main(String[] args) {
        System.out.println(maximumGain("cdbcbbaaabab", 4, 5));
    }

    private static String removeABs(String s, int x) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == 'a' && ch == 'b') {
                stack.pop();
                res += x;
            } else {
                stack.push(ch);
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }

    private static String removeBAs(String s, int y) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (!stack.isEmpty() && stack.peek() == 'b' && ch == 'a') {
                stack.pop();
                res += y;
            } else {
                stack.push(ch);
            }
        }

        StringBuilder sb = new StringBuilder();

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.reverse().toString();
    }

    public static int maximumGain(String s, int x, int y) {
        if (s == null || s.isEmpty() || x == 0 || y == 0) {
            return 0;
        }

        if (x > y) {
            s = removeABs(s, x);
            s = removeBAs(s, y);
        } else {
            s = removeBAs(s, y);
            s = removeABs(s, x);
        }

        return res;
    }
}
