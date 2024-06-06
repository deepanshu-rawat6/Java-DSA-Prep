package com.deepanshu.dsa_practice.practice;

import java.util.Scanner;

public class ThreeFactor {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] nums = new long[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextLong();
        }
        for (long num : nums) {
            System.out.println(isTPrime(num) ? "YES" : "NO");
        }
    }

    public static boolean isTPrime(long num) {
        if (num == 1) {
            return false;
        }
        long sqrt = (long) Math.sqrt(num);
        if (sqrt * sqrt != num) {
            return false;
        }
        return isPrime(sqrt);
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
