package com.deepanshu.dsa.stacks;

import com.deepanshu.dsa_practice.leetcode.MinStack;

import java.util.Stack;

public class MinStackProblem {
    static Stack<Integer> stack;
    static int min;
    public MinStackProblem () {
        stack = new Stack<>();
    }

    public int getMin() {
        if (stack.isEmpty()) {
            return -1;
        }
        return min;
    }

    public void push(int val) {
        if (stack.isEmpty()) {
            stack.add(val);
            min = val;
        } else {
            if (val >= min) {
                stack.add(val);
            } else {
                stack.add(2 * val - min);
                min = val;
            }
        }
    }

    public void pop() {
        if (stack.isEmpty()) {
            return;
        } else {
            if (stack.peek() >= min) {
                stack.pop();
            } else {
                min = 2 * min - stack.peek();
                stack.pop();
            }
        }
    }

    public int top() {
        if (stack.isEmpty()) {
            return -1;
        } else {
            if (stack.peek() >= min) {
                return stack.peek();
            } else {
                return min;
            }
        }
    }

    public static void main(String[] args) {
        MinStackProblem obj = new MinStackProblem();

        obj.push(2147483646);
        obj.push(2147483646);
        obj.push(2147483647);
//        System.out.println(stack);
        System.out.println(obj.top());
        obj.pop();
//        System.out.println(stack);
        System.out.println(obj.getMin());
        obj.pop();
//        System.out.println(stack);
        System.out.println(obj.getMin());
        obj.pop();
//        System.out.println(stack);
        obj.push(2147483647);
        System.out.println(obj.top());
        System.out.println(obj.getMin());

//        Overflow issue
        obj.push(-2147483648);
        System.out.println(stack);
        System.out.println(obj.top());
        System.out.println(obj.getMin());
//        System.out.println(stack);
        obj.pop();
        System.out.println(obj.getMin());
    }
}


// Overflow due to Integer limits, will try using Long
