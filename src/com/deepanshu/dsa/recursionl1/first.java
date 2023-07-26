package com.deepanshu.dsa.recursionl1;

import java.util.Scanner;

public class first {
    public static void main(String[] args) {
        int a=5;
        int b=10;
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println("a+b= " +(a+b) );
        System.out.print(Print(a,b) );
    }
    static int Print(int a,int b){
        return a+b;
    }
}
