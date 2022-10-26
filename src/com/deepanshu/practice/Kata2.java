package com.deepanshu.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Kata2 {
    public static void main(String[] args) {
        System.out.println(sumDigPow(1,100));
        System.out.println(sumDigPow(10,100));
        System.out.println(sumDigPow(90,100));
        System.out.println(sumDigPow(10,200));
        System.out.println(sumDigPow(10,150));
    }
    public static List<Long> sumDigPow(long a, long b) {
        // your code
        ArrayList<Long> ans = new ArrayList<>();
        for (long i = a ; i<= b ; i++){
            long ele = helper(i);
            if ( ele != -1 ){
                ans.add(ele);
            }
        }
        return ans;
    }
    public static long helper(long n) {
        // your code
        long pow = 0;
        int digits = ( int )Math.log10( n ) +1;
        long temp = n;
        while (temp > 0 ){
            pow += ( long )Math.pow( temp % 10, digits );
            digits--;
            temp /=10;
        }
        return ( pow == n ) ? n : -1;
    }
}
