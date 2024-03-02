package com.deepanshu.dsa_practice.leetcode;

import java.util.Arrays;

public class MaximumOddBinaryNumber {
//    public static void swap(char[] arr, int i, int j) {
//        char temp = arr[i];
//        arr[i] = arr[j];
//        arr[j] = temp;
//    }
//
//    public static String maximumOddBinaryNumber(String s) {
//        StringBuilder sb = new StringBuilder();
//        char[] arrChar = s.toCharArray();
//        Arrays.sort(arrChar);
//        int len = arrChar.length - 1;
//        int i = 0, j = len - 1;
//        while (i <= j) {
//            if (arrChar[j] == '1' && arrChar[i] == '0') {
//                swap(arrChar, i, j);
//            }
//            i++;
//            j--;
//        }
//        for (char chr : arrChar) {
//            sb.append(chr);
//        }
//        return sb.toString();
//    }

    public static String maximumOddBinaryNumber(String s) {
        StringBuilder sb = new StringBuilder();
        char[] arrChar = s.toCharArray();
        int countOne = 0, oneAtBegin = 0;
        for (char chr : arrChar) {
            if (chr == '1') {
                countOne++;
            }
        }

        for(char chr : arrChar) {
            if (chr == '1' && countOne == 1) {
                sb.append(chr);
                countOne--;
            } else if (chr == '1' && countOne > 0) {
                sb.insert(0, chr);
                oneAtBegin++;
                countOne--;
            } else {
                sb.insert(oneAtBegin, chr);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
//        String s = "010";
        String s = "0111";
        System.out.println(maximumOddBinaryNumber(s));
    }
}
