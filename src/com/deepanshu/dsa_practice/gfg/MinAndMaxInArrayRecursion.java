package com.deepanshu.dsa_practice.gfg;

public class MinAndMaxInArrayRecursion {
    public static void main(String[] args) {
        int[] arr = {1, 4, 3, -5, -4, 8, 6};
//        findMinMax(arr, Integer.MAX_VALUE, 0, 0);
        System.out.println(findMin(arr, arr.length));
        System.out.println(findMax(arr, arr.length));
    }

    public static void findMinMax(int[] arr, int min, int max, int idx) {
        if (idx == arr.length) {
            System.out.println("Min in the array: " + min);
            System.out.println("Max in the array: " + max);
            return;
        }

        min = Math.min(min, arr[idx]);
        max = Math.max(max, arr[idx]);

        findMinMax(arr, min, max, idx + 1);
    }

    public static int findMin(int[] arr, int idx) {
        if (idx == 1) {
            return arr[0];
        }

        return Math.min(arr[idx - 1], findMin(arr, idx - 1));
    }

    public static int findMax(int[] arr, int idx) {
        if (idx == 1) {
            return arr[0];
        }

        return Math.max(arr[idx - 1], findMax(arr, idx - 1));
    }
}
