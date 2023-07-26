package com.deepanshu.dsa.recursion;

import java.util.Scanner;
public class FibonacciNthTermFormula {
    public static void main(String[] args) {
//        System.out.println("Using formula!!");
//        for (int i = 0; i < 11 ; i++) {
//            System.out.println(fiboFormula(i));
//        }
//        System.out.println("Now using Recursion!!");
//        for (int i = 0; i < 11; i++) {
//            System.out.println(fibo(i));
//        }
        System.out.println(fiboFormula(93));

    }

    static long fiboFormula(int n) {
        double x=Math.pow((1+Math.sqrt(5))/2,n);
        double y=Math.pow((1-Math.sqrt(5))/2,n);
        return (long)((x-y)/(Math.sqrt(5)));
    }

    static int fibo(int n) {
        if (n < 2) return n;
        return fibo(n - 1) + fibo(n - 2);
    }
}
