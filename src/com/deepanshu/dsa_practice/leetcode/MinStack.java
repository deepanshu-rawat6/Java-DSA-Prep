package com.deepanshu.dsa_practice.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

public class MinStack {
    static Stack<Integer> stack;
    static int min = Integer.MAX_VALUE;
    public MinStack() {
        stack = new Stack<>();
    }

    public void push(int val) {
        if (val <= min) {
            stack.push(min);
            min = val;
        }
        stack.push(val);
    }

    public void pop() {
        if (stack.peek() == min) {
            stack.pop();
            min = stack.pop();
        } else {
            stack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return min;
    }

    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(-1);
//        System.out.println(obj.getMin());
        System.out.println(obj.top());
        System.out.println(stack);
//        obj.pop();
//        System.out.println(stack);
        System.out.println(obj.getMin());
//        System.out.println(pq);
//        obj.pop();
//        System.out.println(pq);
//        System.out.println("Top: " + obj.top());
//        System.out.println(pq);
//        System.out.println("Get Min: " + obj.getMin());
//        System.out.println(pq);
    }
}

//Brute Force above!
