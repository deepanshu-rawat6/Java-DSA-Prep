package com.deepanshu.dsa.sortingalgo;

import java.lang.reflect.Array;
import java.util.Arrays;

public class RadixSort {
    public static void countingsort(int[] arr,int pos) {
        int[] count = new int[10];
        int[] sorted = new int[arr.length];
        for(int i: arr) {
            count[(i / pos) % 10]++;
        }
        for (int i = 1; i < 10; i++) {
            count[i] = count[i] + count[i - 1];
        }
        for (int i = arr.length -1; i >= 0; i--) {
            sorted[--count[(arr[i] / pos) % 10]] = arr[i];
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sorted[i];
        }
    }
    public static int getMax(int[] arr) {
        int max = 0;
        for(int i: arr) {
            if (max < i) {
                max = i;
            }
        }
        return max;
    }
    public static void main(String[] args) {
        int[] arr = {432,8,530,90,88,231,11,45,677,199};
        System.out.println(Arrays.toString(arr));
        int max = getMax(arr);
        int pos = 1;
        do{
            countingsort(arr,pos);
            pos *= 10;
            max /= 10;
        } while (max != 0);
        System.out.println(Arrays.toString(arr));
    }
}
