package com.deepanshu.dsa_practice.leetcode.twopointers;

import com.deepanshu.dsa.dsamaths.BinarySearchSQRT;

import java.util.HashSet;

public class SumofSquareNumbers {
    public static void main(String[] args) {
        int c = 999999999;
        System.out.println(judgeSquareSum(c));
    }

    public static boolean judgeSquareSum(int c) {
//        long start = 0;
//        long end = (long) Math.sqrt(c);
//
//        while (start <= end) {
//            long sum = start * start + end * end;
//            if (sum == c) {
//                return true;
//            } else if (sum > c) {
//                end--;
//            } else {
//                start++;
//            }
//        }
//
//        return false;


        HashSet<Long> set = new HashSet<>();

        long val = (long)Math.sqrt(c);

        for (long i = 0; i <= val; i++) {
            set.add(i * i);
        }

        for (Long aSq : set) {
            long bSq = c - aSq;
            if (set.contains(bSq)) {
                return true;
            }
        }

        return false;
    }

}
