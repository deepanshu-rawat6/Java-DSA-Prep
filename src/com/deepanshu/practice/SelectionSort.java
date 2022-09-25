package com.deepanshu.practice;

import java.util.Arrays;

public class SelectionSort {
    public static void main(String[] args) {
        int[] arr={10,9,8,7,6,5,4,3,2,1};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void sort(int[] arr){
        int n=arr.length;
        int small=0;
        for(int i=0;i<n-1;i++){
            small=i;
            for(int j=i+1;j<n;j++){
                if(arr[small]>arr[j]){
                    small=j;
                }
            }
            int temp=arr[small];
            arr[small]=arr[i];
            arr[i]=temp;
        }
    }
}
