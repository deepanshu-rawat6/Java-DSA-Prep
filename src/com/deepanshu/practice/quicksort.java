package com.deepanshu.practice;

import java.util.Arrays;

public class quicksort {
    public static void main(String[] args) {
        int[] arr = new int[]{1000,-999,23,23,43,43,1,2,32,421,214};
        QS(arr,0,10);
        System.out.println(Arrays.toString(arr));
    }
    static void QS(int []arr,int low,int high){
        if(low>=high){
            return;
        }
        int s=low;
        int e=high;
        int m=s+(e-s)/2;
        int pivot=arr[m];

        while(s<=e){
            while(arr[s]<pivot){
                s++;
            }
            while(arr[e]>pivot){
                e--;
            }

            if(s<=e){
                int temp=arr[s];
                arr[s]=arr[e];
                arr[e]=temp;
                s++;
                e--;
            }
        }
        QS(arr,low,e);
        QS(arr,s,high);
    }
}
