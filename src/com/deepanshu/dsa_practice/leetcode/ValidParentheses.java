package com.deepanshu.dsa_practice.leetcode;

import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
//        String s = "()";
//        String s = "(){}[]";
        String s = "([{}])";
//        String s = "([)]";
//        String s = "({{{{}}}))";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        if (s.length() % 2 != 0) {
            return false;
        }

        for (char ch : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.add(ch);
            } else {
                if (stack.peek() == '(' && ch == ')') {
                    stack.pop();
                } else if (stack.peek() == '[' && ch == ']') {
                    stack.pop();
                } else if (stack.peek() == '{' && ch == '}') {
                    stack.pop();
                } else {
                    stack.add(ch);
                }
            }

            System.out.println(stack);
        }

        return stack.isEmpty();
    }
}
