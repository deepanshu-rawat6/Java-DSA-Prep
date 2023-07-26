package com.deepanshu.java.basics;

import java.util.Scanner;

public class Fibo {
    public void compute(int n) {
        int a = 0,b = 1;
        if (n == 0) {
            System.out.println(a);
        } else if (n <= 2){
            System.out.println(b);
        } else {
            a = 1;
            int sum = 0;
            for (int i = 3; i <= n; i++) {
                sum = a + b;
                a = b;
                b = sum;
            }
            System.out.println(sum);
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Fibo obj = new Fibo();
        System.out.println("Enter the nth Fibonacci number:");
        int n = sc.nextInt();
        obj.compute(n);
    }
}

// 0,1,1,2,3,5