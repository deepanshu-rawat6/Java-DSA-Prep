package com.deepanshu.dsa_practice.practice;

import java.util.Arrays;
import java.util.Scanner;

public class MinimumDishes {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t != 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }
            System.out.println(compute(n, k, nums));
            t--;
        }
    }

    public static int compute(int n, int k, int[] nums) {
        int c = 0;
        Arrays.sort(nums);
        for (int i = 0; i < n - 1; i++) {
            if (nums[i + 1] - nums[i] <= k) {
                c++;
            }
        }

        return n - c;
    }
}
