package com.deepanshu.dsa_practice.practice;

import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {
        int[] arr={23, 4, 3, 5, 6, 778, 2, 12, -1, 0};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void swap(int [] arr,int a,int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
    static void sort(int [] arr){
        for (int i = 0; i <arr.length-1 ; i++) {
            for (int j = i+1; j>0 ; j--) {
                if (arr[j]<arr[j-1]){
                    //simple swapping function
                    swap(arr, j,j-1);
                }else{
                    //if element at j is greater than element at j-1 so no need to check any further as the LHS is already sorted
                    break;
                }
            }
        }
    }
}
