package com.deepanshu.practice;

import java.util.Arrays;

public class Small_Large {
    static int a;
    static int b;
    public static void compute(int[] arr) {
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        int[] final_arr = new int[arr.length];
        int k = 0;
        for (int i = 0; i < arr.length / 2; i++) {
            final_arr[i + k] = arr[i];
            final_arr[i + k + 1] = arr[arr.length - 1 - i];
            k++;
        }
        System.out.println(Arrays.toString(final_arr));
    }

    public static void compute2(int a,int b) {
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("a: " + a + " " + "b: " + b);
    }
    public static void main(String[] args) {
        compute(new int[]{10,9,8,7,6,5,4,3,2,1});
        int a = 5, b = 10;
        compute2(a,b);
        System.out.println("a: " + a + " " + "b: " + b);
    }
}
