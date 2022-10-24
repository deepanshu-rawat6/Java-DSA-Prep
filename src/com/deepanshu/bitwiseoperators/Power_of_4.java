package com.deepanshu.bitwiseoperators;

import java.util.Scanner;

public class Power_of_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        System.out.println(check_pow(x));
    }
    public static boolean check_pow(int x){
        return x>0 && (x & (x-1)) == 0 && (x-1) % 3 == 0;
//        return x > 0  && (x & (x - 1)) == 0 && x + 2 % 3 == 0;
    }
}
