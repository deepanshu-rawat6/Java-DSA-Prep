package com.deepanshu.dsa_practice;

public class Random {
    public static void main(String[] args) {

    }

    public static int[] findTriplet(int n) {
        if (n % 3 == 0) {
            var x = n / 3 - 1;
            return new int[]{x, x + 1, x + 2};
        } else {
            return new int[]{-1};
        }
    }
}
