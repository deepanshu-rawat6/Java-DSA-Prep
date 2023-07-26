package com.deepanshu.java.functions;

import java.util.Arrays;

public class Vargs {
    public static void main(String[] args) {
        func(1,2,3,4,43,43,5,34,34,6,6,45,47,56,7);
    }

    public static void func(int ...v) {
        System.out.println(Arrays.toString(v));
    }
}
