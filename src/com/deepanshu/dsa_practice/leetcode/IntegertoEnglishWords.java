package com.deepanshu.dsa_practice.leetcode;

public class IntegertoEnglishWords {
    private static final String[] belowTen = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    private static final String[] belowTwenty = {"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private static final String[] tensBelowHundred = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    static StringBuilder sb;

    public static void main(String[] args) {
        int num = 123;

        System.out.println(numberToWords(num));
    }

    public static String numberToWords(int num) {
        if (num == 0) return "Zero";

        return helper(num).trim();
    }

    private static String helper(int num) {
        StringBuilder sb = new StringBuilder();

        if (num >= 1000000000) {
            sb.append(helper(num / 1000000000)).append(" Billion ").append(helper(num % 1000000000));
        } else if (num >= 1000000) {
            sb.append(helper(num / 1000000)).append(" Million ").append(helper(num % 1000000));
        } else if (num >= 1000) {
            sb.append(helper(num / 1000)).append(" Thousand ").append(helper(num % 1000));
        } else if (num >= 100) {
            sb.append(helper(num / 100)).append(" Hundred ").append(helper(num % 100));
        } else if (num >= 20) {
            sb.append(tensBelowHundred[num / 10]).append(" ").append(helper(num % 10));
        } else if (num >= 10) {
            sb.append(belowTwenty[num - 10]);
        } else {
            sb.append(belowTen[num]);
        }
        return sb.toString().trim();
    }
}
