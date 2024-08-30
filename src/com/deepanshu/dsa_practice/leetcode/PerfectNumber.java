package com.deepanshu.dsa_practice.leetcode;

public class PerfectNumber {
    public static void main(String[] args) {
        int num = 28;

        System.out.println(isPerfectNumber(num));
    }

    public static boolean isPerfectNumber(int num) {
        if (num <= 1) {
            return false;
        }

        int sum = 1;

        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                sum += i;
                if (i * i != num) {
                    sum += num / i;
                }
            }
        }

        return sum == num;
    }
}
