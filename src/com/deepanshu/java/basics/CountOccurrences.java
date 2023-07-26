package com.deepanshu.java.basics;

import java.util.Scanner;

public class CountOccurrences {

    public int compute(int n,int m) {
        int c = 0;
        do {
            int r = n % 10;
            if (r == m) {
                c++;
            }
            n /= 10;
        } while(n != 0);
        return c;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        CountOccurrences obj = new CountOccurrences();
        System.out.println("Enter the number, and the digit to be looked for:");
        int n = sc.nextInt();
        int m = sc.nextInt();
        System.out.println("The occurrence of " + m +" in " + n + " : " + obj.compute(n,m));
    }
}