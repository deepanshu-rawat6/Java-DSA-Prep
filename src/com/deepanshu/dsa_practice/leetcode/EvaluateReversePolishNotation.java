package com.deepanshu.dsa_practice.leetcode;

import java.util.Stack;

public class EvaluateReversePolishNotation {
    public static void main(String[] args) {
//        String[] token = {"2","1","+","3","*"};
//        String[] token = {"4","13","5","/","+"};
        String[] token = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
//        String[] token = {"4","3","-"};
        System.out.println(evalRPN(token));
    }

//    Brute Force!
//    public static int evalRPN(String[] tokens) {
//        Stack<String> stack = new Stack<>();
//        for (int i = 0; i < tokens.length; i++) {
//            int res = 0, op1 = 0 , op2 = 0;
//            if (tokens[i].equals("+")){
//                op1 = Integer.parseInt(stack.pop());
//                op2 = Integer.parseInt(stack.pop());
//                res = op1 + op2;
//                stack.push(String.valueOf(res));
//            } else if (tokens[i].equals("-")){
//                op1 = Integer.parseInt(stack.pop());
//                op2 = Integer.parseInt(stack.pop());
//                res = op2 - op1;
//                stack.push(String.valueOf(res));
//            } else if (tokens[i].equals("*")){
//                op1 = Integer.parseInt(stack.pop());
//                op2 = Integer.parseInt(stack.pop());
//                res = op1 * op2;
//                stack.push(String.valueOf(res));
//            } else if (tokens[i].equals("/")){
//                op1 = Integer.parseInt(stack.pop());
//                op2 = Integer.parseInt(stack.pop());
//                res = op2 / op1;
//                stack.push(String.valueOf(res));
//            } else {
//                stack.push(tokens[i]);
//            }
//        }
//        return Integer.parseInt(stack.peek());
//    }


//    A little bit of optimization
//    public static int evalRPN(String[] tokens) {
//        Stack<String> stack = new Stack<>();
//        for (String token : tokens) {
//            int res = 0, op1 = 0, op2 = 0;
//            switch (token) {
//                case "+" -> {
//                    op1 = Integer.parseInt(stack.pop());
//                    op2 = Integer.parseInt(stack.pop());
//                    res = op1 + op2;
//                    stack.push(String.valueOf(res));
//                }
//                case "-" -> {
//                    op1 = Integer.parseInt(stack.pop());
//                    op2 = Integer.parseInt(stack.pop());
//                    res = op2 - op1;
//                    stack.push(String.valueOf(res));
//                }
//                case "*" -> {
//                    op1 = Integer.parseInt(stack.pop());
//                    op2 = Integer.parseInt(stack.pop());
//                    res = op1 * op2;
//                    stack.push(String.valueOf(res));
//                }
//                case "/" -> {
//                    op1 = Integer.parseInt(stack.pop());
//                    op2 = Integer.parseInt(stack.pop());
//                    res = op2 / op1;
//                    stack.push(String.valueOf(res));
//                }
//                default -> stack.push(token);
//            }
//        }
//        return Integer.parseInt(stack.peek());
//    }

    public static int evalRPN(String[] tokens) {
        int op1, op2;
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            switch (token) {
                case "+" -> stack.push(stack.pop() + stack.pop());
                case "-" -> {
                    op1 = stack.pop();
                    op2 = stack.pop();
                    stack.push(op2 - op1);
                }
                case "*" -> stack.push(stack.pop() * stack.pop());
                case "/" -> {
                    op1 = stack.pop();
                    op2 = stack.pop();
                    stack.push(op2 / op1);
                }
                default -> stack.push(Integer.valueOf(token));
            }
        }
        return stack.peek();
    }
}
