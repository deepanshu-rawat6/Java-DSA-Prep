package com.deepanshu.dsa.recursionl1;

import java.util.Scanner;

public class Reverse_Num {
    static int sum=0;
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
//        rev_1(n);
//        System.out.println(rev2(n));
//        System.out.println(sum);
        System.out.println(rev_3(n));
    }
    public static int rev2(int n){
        int digits = (int)(Math.log10(n)) + 1;
        return helper(n , digits);
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
        sum = sum * 10 + rem;
        rev_1(n / 10);
    }

    static int result = 0;
    private static int rev_3(int n) {
        if ( n % 10 == n) {
            return n;
        }
        int rem = n % 10;
        result = result * 10 + rem + rev_3(n/10);
        return result;
    }
}
