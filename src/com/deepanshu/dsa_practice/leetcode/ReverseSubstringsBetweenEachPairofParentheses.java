package com.deepanshu.dsa_practice.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class ReverseSubstringsBetweenEachPairofParentheses {
    static int i = 0;
    public static void main(String[] args) {
        System.out.println(reverseParentheses("a(bcdefghijkl(mno)p)q"));
    }

    public static String reverseParentheses(String s) {
        Deque<String> deque = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char chr = s.charAt(i);

            if (chr == '(') {
                deque.push("(");
            } else if (chr == ')') {
                StringBuilder rev = new StringBuilder();
                while (!deque.isEmpty() && !deque.peek().equals("(")) {
                    rev.append(new StringBuilder(deque.pop()).reverse());
                }

                deque.pop();
                deque.push(rev.toString());
            } else {
                deque.push(String.valueOf(chr));
            }
        }

        StringBuilder res = new StringBuilder();
        while (!deque.isEmpty()) {
            res.insert(0, deque.pop());
        }

        return res.toString();
    }
}
