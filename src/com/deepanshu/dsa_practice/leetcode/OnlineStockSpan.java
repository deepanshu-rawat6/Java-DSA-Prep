package com.deepanshu.dsa_practice.leetcode;

import java.util.List;
import java.util.Stack;

class Pairr <K,V> {
    int span;
    int price;

    Pairr(int span, int price) {
        this.span = span;
        this.price = price;
    }
}

public class OnlineStockSpan {
    Stack<Pairr<Integer, Integer>> stack;

    public OnlineStockSpan() {
        stack = new Stack<>();
    }

    public int next(int price) {
        int span = 1;
        while (!stack.isEmpty() && stack.peek().price <= price) {
            span += stack.peek().span;
            stack.pop();
        }

        stack.push(new Pairr<>(span, price));

        return span;
    }

    public static void main(String[] args) {
        OnlineStockSpan obj = new OnlineStockSpan();
        System.out.println(obj.next(100));
        System.out.println(obj.next(80));
        System.out.println(obj.next(60));
        System.out.println(obj.next(70));
        System.out.println(obj.next(60));
        System.out.println(obj.next(75));
        System.out.println(obj.next(85));
    }
}
