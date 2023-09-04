package com.deepanshu.dsa.recursionl1;

import java.util.Scanner;

public class Palindrome {
    static int sum=0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
//        int s = (int)Math.pow(10,(int)Math.log10(n));
//        int e = 10;
        System.out.println(palindrome(n));
    }

    public static boolean palindrome(int n) {
        return n == rev2(n);
    }

    public static int rev2(int n){
        int digits = (int)(Math.log10(n)) + 1;
        return helper(n, digits);
    }
    private static int helper(int n, int digits) {
        if(n % 10 == n){
            return n;
        }
        int rem = n % 10;
        return rem * (int)Math.pow(10 ,digits - 1) + helper(n / 10,digits - 1);
    }
    private static void rev_1(int n) {
        if(n == 0) return;
        int rem = n % 10;
        sum= sum * 10 + rem;
        rev_1(n / 10);
    }
}
