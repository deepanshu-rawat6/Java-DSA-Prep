package com.deepanshu.practice;

import java.util.Arrays;

public class InsertionSort2 {
    public static void main(String[] args) {
        int[] arr={23, 4, 3, 5, 6, 778, 2, 12, -1, 0};
        IS(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void IS(int []arr){
        int i,j,temp;
        for(i=1; i< 10; i++){
            temp=arr[i];
            j=i-1;
            while(j>=0 && temp<=arr[j]){
                arr[j+1]=arr[j];
                j=j-1;
            }
            arr[j+1]=temp;
        }
    }
}
