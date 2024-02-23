package com.deepanshu.dsa_practice.gfg;

import java.util.Arrays;

public class SumTriangleFromArray {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
//        sumTrianlge(arr);
        sumTrianlge2(arr);
    }

    public static void sumTrianlge(int[] arr) {
        if (arr.length < 1) {
            return;
        }

        int[] temp = new int[arr.length - 1];
        for (int i = 0; i < arr.length - 1; i++) {
            int x = arr[i] + arr[i + 1];
            temp[i] = x;
        }

        sumTrianlge(temp);

        System.out.println(Arrays.toString(arr));
    }

    public static void sumTrianlge2(int[] arr) {
        if (arr.length < 1) {
            return;
        }

        int[] temp = new int[arr.length - 1];
        helper(arr, temp, 0);

        sumTrianlge2(temp);

        System.out.println(Arrays.toString(arr));
    }

    public static int[] helper(int[] arr, int[] temp, int idx) {
        if (idx == arr.length - 1) {
            return temp;
        }

        temp[idx] = arr[idx] + arr[idx +  1];

        return helper(arr, temp, idx + 1);
    }
}
