package com.deepanshu.recursionl1;

import java.util.Scanner;

public class SOD {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(sum_of_digits(n));
        System.out.println(prod(n));

    }
    public static int sum_of_digits(int n){
        if(n<10) return n;
        return n%10+sum_of_digits(n/10);
    }
    public static int prod(int n){
        if(n<10) return n;
        return n%10*prod(n/10);
    }
}