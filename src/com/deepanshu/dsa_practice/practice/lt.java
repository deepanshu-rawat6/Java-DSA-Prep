package com.deepanshu.dsa_practice.practice;

public class lt {
    public static void main(String[] args) {
        int [] arr={0,1,3,5,2,7,6};
        System.out.println(missingNumber(arr));
    }
        static public int missingNumber(int[] arr) {
            int i = 0;
            sort(arr);
            for(i=0;i<arr.length;i++){
                if(arr[i]!=i){
                    return i;
                }
            }
            return arr.length;
        }
        static void swap(int [] arr,int a,int b){
            int temp=arr[a];
            arr[a]=arr[b];
            arr[b]=temp;
        }
        static void sort(int[] arr){
            int i=0;
            while(i<arr.length){
                int correct=arr[i];
                if(arr[i]<arr.length && arr[i]!=arr[correct]){
                    swap(arr,i,correct);
                }else{
                    i++;
                }}
    }
}

