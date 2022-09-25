package com.deepanshu.DAA.Divide_and_Conquer;

import java.util.Arrays;

public class merge_sort {
    public static void main(String[] args) {
        int[] arr={10,9,8,7,6,5,4,3,2,1};
//        mergesort(arr,0,arr.length-1);
        sort(arr,0,arr.length);
        System.out.println(Arrays.toString(arr));
    }

    private static void mergesort(int[] arr, int low, int high) {
        if(low<high){
            int mid=low+(high-low)/2;
            mergesort(arr,low,mid);
            mergesort(arr,mid+1,high);
            merge(arr,low,mid,high);
        }
    }

    private static void merge(int[] arr, int low, int mid, int high) {
        int n1=mid-low+1;
        int n2=high-mid;
        int[] L=new int[n1];
        int[] R=new int[n2];
        for(int i=0;i<n1;i++){
            L[i]=arr[low+i];
        }
        for(int j=0;j<n2;j++){
            R[j]=arr[mid+j+1];
        }
        int i=0,j=0;
        int k=low;
        while(i<n1 && j<n2){
            if(L[i]>R[j]){
                arr[k]=R[j];
                j++;
            }else{
                arr[k]=L[i];
                i++;
            }
            k++;
        }

        while(i<n1){
            arr[k]=L[i];
            i++;
            k++;
        }
        while(j<n2){
            arr[k]=R[j];
            j++;
            k++;
        }
    }

    static void sort(int[] arr, int low, int high){
        if(high-low ==1){
            return;
        }
        int mid=low+(high-low)/2;
        sort(arr,0,mid);
        sort(arr,mid,high);
        merge_in_place(arr,low,mid,high);
    }
    static void merge_in_place(int[] arr, int low, int mid, int high){
        int[] mix=new int[high-low];
        int i=low,j=mid,k=0;
        while(i<mid && j<high){
            if(arr[i]<arr[j]){
                mix[k]=arr[i];
                i++;
            }else{
                mix[k]=arr[j];
                j++;
            }
            k++;
        }
//        it may be possible that some elements of either arrays are left out, so we need to add then into the mix array
        while(i<mid){
            mix[k]=arr[i];
            i++;
            k++;
        }
        while(j<high){
            mix[k]=arr[j];
            j++;
            k++;
        }

        for (int l=0;l<mix.length;l++){
            arr[low+l]=mix[l];
        }
    }
}
