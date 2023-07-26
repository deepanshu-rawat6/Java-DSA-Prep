package com.deepanshu.dsa.recursionl1;

import java.util.Scanner;

public class print_n_to_1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        print(n);
        System.out.println();
        Revprint(n);
        System.out.println();
        Bothprint(n);
    }

    private static void print(int n) {
        if(n==0) return;
        System.out.print(n+" ");
        print(n-1);
    }
    private static void Revprint(int n) {
        if(n==0) return;

        Revprint(n-1);
        System.out.print(n+" ");
    }
    private static void Bothprint(int n) {
        if(n==0) return;
        System.out.print(n+" ");
        Bothprint(n-1);
        System.out.print(n+" ");
    }
}
