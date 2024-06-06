package com.deepanshu.dsa_practice.practice;


import java.util.Scanner;

public class MIN_CHANGES_DISTINCT {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t != 0) {
            String str = sc.next();
            System.out.println(solve(str));
            t--;
        }
    }

    public static int solve(String str) {
        int count = 0;
        int[] charCount = new int[26];
        for (char ch : str.toCharArray()) {
            charCount[ch - 'a']++;
        }

        for (int val : charCount) {
            if (val > 1) {
                count += val - 1;
            }
        }

        return count;
    }
}
