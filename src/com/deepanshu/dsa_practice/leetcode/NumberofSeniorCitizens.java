package com.deepanshu.dsa_practice.leetcode;

public class NumberofSeniorCitizens {
    public static void main(String[] args) {
        String[] details = {"7868190130M7522","5303914400F9211","9273338290F4010"};

        System.out.println(countSeniors(details));
    }

    public static int countSeniors(String[] details) {
        int res = 0;

        for (String str : details) {
            var age = (str.charAt(11) - '0') * 10 + str.charAt(12) - '0';

            if (age > 60) {
                res++;
            }
        }

        return res;
    }
}
