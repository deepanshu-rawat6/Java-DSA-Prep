package com.deepanshu.dsa_practice.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;

public class MinStack {
// //    static Stack<Integer> stack;
// //    static int min = Integer.MAX_VALUE;
//     static Stack<Integer> stack;
//     static Stack<Integer> supportStack;

//     public MinStack() {
//         // stack = new Stack<>();
//         stack = new Stack<>();
//         supportStack =new Stack<>();
//     }

//     public void push(int val) {
// //        if (val <= min) {
// //            stack.push(min);
// //            min = val;
// //        }
// //        stack.push(val);

//         if (val < supportStack.peek()) {
//             supportStack.push(val);
//         }
//         stack.push(val);
//     }

//     public void pop() {
//         if (stack.peek() == supportStack.peek()) {
//             stack.pop();
//             supportStack.pop();
//         } else {
//             stack.pop();
//         }
//     }

//     public int top() {
//         return stack.peek();
//     }

//     public int getMin(int val) {
//         if (stack.isEmpty()) {
//             return -1;
//         } else {
//             return supportStack.peek();
//         }
//     }
    static Stack<Integer> stack;
    static Stack<Integer> supportStack;

    public MinStack() {
        stack = new Stack<>();
        supportStack = new Stack<>();
    }

    public void push(int val) {
        stack.add(val);
        if (supportStack.isEmpty() || supportStack.peek() >= val) {
            supportStack.add(val);
        }
        return;
    }

    public void pop() {
        if (stack.isEmpty()) {
            System.out.println(-1);
        }
        int ans = stack.peek();
        stack.pop();
        if (supportStack.peek() == ans) {
            supportStack.pop();
        }
        System.out.println(ans);
    }

    public int top() {
        return stack.peek();   
    }

    public int getMin() {
        if (stack.isEmpty()) {
            return -1;
        } 
        return supportStack.peek();
    } 



    public static void main(String[] args) {
        MinStack obj = new MinStack();
        obj.push(0);
        obj.push(1);
        obj.push(0);
        System.out.println(stack);
        System.out.println(supportStack);
        System.out.println(obj.getMin());
        obj.pop();
        System.out.println(obj.getMin());
        // System.out.println(stack);
        // System.out.println(supportStack);
    //    obj.pop();
//        System.out.println(stack);
        // System.out.println(obj.getMin());
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
