package com.deepanshu.dsa_practice.practice;

import java.util.Arrays;

public class CyclicSort {
    public static void main(String[] args) {
        int[] arr= new int[]{4,5,3,1,2};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    static void swap(int [] arr,int a,int b){
        int temp=arr[a];
        arr[a]=arr[b];
        arr[b]=temp;
    }
    static void sort(int [] arr) {
        int i = 0;
        while(i<arr.length){
             int correct=arr[i]-1;
             if(arr[i]!=arr[correct]){
                 swap(arr,i,correct);
             }else{
                 i++;
             }
        }
    }
}
