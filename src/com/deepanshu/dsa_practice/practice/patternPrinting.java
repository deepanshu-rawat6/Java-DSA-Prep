package com.deepanshu.dsa_practice.practice;

public class patternPrinting {
    public static void main(String[] args) {
        printPattern(5);
        System.out.println(gcd(100,89));
    }

    public static int gcd(int a, int b) {
        return (b == 0) ? a : gcd(b, a % b);
    }

    public static void printPattern(int n) {
        int i, j, c = 0, k = 0;
        for (i = 1; i <= n; i++) {
            c = k;
            for (j = 1; j <= i; j++) {
                if (i % 2 == 0) {
                    System.out.print(c + i);
                    c -= 1;
                    if (j != i)
                        System.out.print("*");
                    k++;
                } else {
                    c = c + 1;
                    System.out.print(c + i);
                    if (j != i)
                        System.out.print("*");
                    k++;
                }
            }

            System.out.println();
        }
    }
}
