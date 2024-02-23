package com.deepanshu.dsa.sortingalgo;

import java.util.Arrays;

public class CyclicSort {
    static void sort(int[] arr) {
        int i = 0, j = arr.length - 1;
        while (i < j) {
            if (arr[i] > arr[j]) {
                swap(arr, i , j);
                j--;
            } else {
                i++;
            }
        }
    }

    static void swap(int[] arr, int first, int second) {
        int temp = arr[first];
        arr[first] = arr[second];
        arr[second] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {1, 0, 2};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
