package com.deepanshu.dsa.recursion;

import java.util.Scanner;

public class ModularExponentiation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of a, b and c, keeping in mind the form as (a ^ b) mod c:");
        long a = sc.nextLong();
        long b = sc.nextLong();
        long c = sc.nextLong();
        fastModuloExponentiation(a, b, c);
        fastModuloExponentiation2(a, b, c);
    }

    public static void fastModuloExponentiation(long a, long b, long c) {
        long t1 = System.nanoTime();
        System.out.println("Fast Modular exponentiation: " + compute(a, b, c));
        long t2 = System.nanoTime();
        System.out.println("Total time taken(in millis): " + (t2 - t1)/100000);
    }

    public static void fastModuloExponentiation2(long a, long b, long c) {
        long t3 = System.nanoTime();
        System.out.println("Fast Modulo exponentiation: " + compute2(a, b, c));
        long t4 = System.nanoTime();
        System.out.println("Total time taken(in millis): " + (t4 - t3)/100000);
    }

    public static long compute(long a, long b, long c) {
        long result = 1;
        a %= c;
        while (b > 0) {
            if ( (b & 1) == 1) {
                result = result * a % c;
            }
            a = a * a % c;
            b = b >> 1;
        }
        return  result;
    }

    public static long compute2(long a, long b, long c) {
        String binaryString = Long.toBinaryString(b);
        char[] binaryArray = binaryString.toCharArray();

        int len = binaryArray.length;

        long[] result = new long[len];

        result[0] = a % c;

        for (int i = 1; i < len; i++) {
            long t = result[i - 1] * result[i - 1] % c;
            if (binaryArray[i] == '1') {
                result[i] = t * a % c;
            } else {
                result[i] = t;
            }
        }

        return result[len - 1];
    }
}
