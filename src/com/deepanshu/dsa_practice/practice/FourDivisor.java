package com.deepanshu.dsa_practice.practice;

import java.util.Scanner;

public class FourDivisor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int d = sc.nextInt();
            System.out.println(findSmallestNumber(d));
        }
    }

    public static long findSmallestNumber(int d) {
        long x = 1 + d;
        while (!isPrime(x)) {
            x++;
        }
        long y = x + d;
        while (!isPrime(y)) {
            y++;
        }
        return x * y;
    }

    public static boolean isPrime(long num) {
        if (num < 2) {
            return false;
        }
        for (long i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

}
