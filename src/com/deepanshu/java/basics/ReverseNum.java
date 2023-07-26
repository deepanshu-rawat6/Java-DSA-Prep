package com.deepanshu.java.basics;

import java.util.Scanner;

public class ReverseNum {

    public int compute(int n) {
        int rev = 0;
        do {
            int r = n % 10;
            rev = rev*10 + r;
            n /= 10;
        } while(n != 0);
        return rev;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ReverseNum obj = new ReverseNum();

        System.out.println("Enter the number to be reversed: ");
        int n = sc.nextInt();

        System.out.println("The reverse of " + n + "is: " + obj.compute(n));
    }
}

/*

n = 123

r =3
rev = 0*10 + 3 = 3
n = 123/10 = 12

r = 2
rev = 3*10 + 2 = 32
n = 12/10 = 1

r = 1
rev = 32 * 10 + 1 = 321
n = 1/10 = 0

break!



 */