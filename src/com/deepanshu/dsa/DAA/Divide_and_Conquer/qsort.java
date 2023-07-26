package com.deepanshu.dsa.DAA.Divide_and_Conquer;

import java.util.Arrays;

public class qsort {
    public static void main(String[] args) {
        int[] arr={10,9,8,7,6,5,4,3,2,1};
//        quicksort(arr,0,arr.length-1);
        sort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
    private static void quicksort(int[] arr, int low, int high) {
        if(low<high){
            int pi=partition(arr,low,high);
            quicksort(arr,low,pi-1);
            quicksort(arr,pi+1,high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot=arr[high];
        int i=low-1;
        for(int j=low;j<high;j++){
            if(arr[j]<pivot){
                i++;
                swap(arr,i,j);
            }
        }
        swap(arr,i+1,high);
        return i+1;
    }

    private static void swap(int[] arr, int i,int j) {
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
    private static void sort(int[] arr, int low,int high){
        if(low>=high){
            return;
        }
        int s=low;
        int e=high;
        int mid = s + (e - s) / 2;
        int pivot = arr[mid];
        while(s<=e) {
            while (arr[s] < pivot) {
                s++;
            }
            while (arr[e] > pivot) {
                e--;
            }
            if (s <= e) {
                swap(arr, s, e);
                s++;
                e--;
            }
        }
        sort(arr,low,e);
        sort(arr,s,high);
    }
}

