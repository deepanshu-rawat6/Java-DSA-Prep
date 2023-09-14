package com.deepanshu.dsa_practice.leetcode;

import java.util.Arrays;

public class ProductofArrayExceptSelf {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
        System.out.println(Arrays.toString(productExceptSelfOptimized(nums)));
    }

    public static int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] Lprod = new int[len];
        int[] Rprod = new int[len];

        int[] resultArr = new int[len];

        Lprod[0] = 1;
        Rprod[len - 1] = 1;

        for (int i = 1; i <= len - 1 ; i++) {
            Lprod[i] = Lprod[i - 1] * nums[i - 1];
        }

        for (int i = len - 2; i >= 0; i--) {
            Rprod[i] = Rprod[i + 1] * nums[i + 1];
        }

        for (int i = 0; i < len; i++) {
            resultArr[i] = Lprod[i] * Rprod[i];
        }

        return resultArr;
    }

    public static int[] productExceptSelfOptimized(int[] nums) {
        int len = nums.length;

        int[] resultArr = new int[len];

        resultArr[0] = 1;

        for (int i = 1; i <= len - 1; i++) {
            resultArr[i] = resultArr[i - 1] * nums[i - 1];
        }

        int R = 1;

        for (int i = len - 1; i >= 0; i--) {
            resultArr[i] = resultArr[i] * R;
            R *= nums[i];
        }

        return resultArr;
    }
}
