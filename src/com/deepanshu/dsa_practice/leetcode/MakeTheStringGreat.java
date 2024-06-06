package com.deepanshu.dsa_practice.leetcode;

import java.util.Stack;

public class MakeTheStringGreat {
    public static void main(String[] args) {
        String s = "abBAcC";
        System.out.println(makeGood(s));
    }

    public static String makeGood(String s) {
        StringBuilder sb = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (!stack.isEmpty() && (stack.peek() - ch == 32 || stack.peek() - ch == -32)) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }

        while (!stack.isEmpty()) {
            sb.insert(0, stack.peek());
            stack.pop();
        }

        return sb.toString();
    }
}
