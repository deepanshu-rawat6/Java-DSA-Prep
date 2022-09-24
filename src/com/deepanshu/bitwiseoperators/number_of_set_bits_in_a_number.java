package com.deepanshu.bitwiseoperators;

import java.util.Scanner;

public class number_of_set_bits_in_a_number {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(Integer.toBinaryString(n));
        System.out.println(set_bits(n));
    }
    public static int set_bits(int n){
        int c=0;
        // Normal solution
        // while(n>0){
        //     if((n&1)==1) c++;
        //     n>>=1;
        // }
        // return c;


        // A good solution
        // while(n>0){
        //     c++;
        //     n-=(n&-n);
        // }
        // return c;


        // Best solution to get the number of set bits in a number
        while(n>0){
            c++;
            n&=(n-1);
        }
        return c;
    }
}
