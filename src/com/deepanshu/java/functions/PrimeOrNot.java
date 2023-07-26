package com.deepanshu.java.functions;

import java.util.Scanner;

public class PrimeOrNot {

    public boolean compute(int n) {
        int i = 2;
        if (n <= 1) {
            return false;
        }
        while(i*i <= n) {
            if (n % i == 0) {
                return false;
            }
            i++;
        }
        return i * i > n;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PrimeOrNot obj = new PrimeOrNot();

        int n = sc.nextInt();
        System.out.println(obj.compute(n));
    }
}
