package com.deepanshu.DAA.Divide_and_Conquer;

public class binary_search {
    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7,8,9,10};
        System.out.println(search(arr,0,arr.length-1,100));
    }

    private static int search(int[] arr, int low, int high,int target) {
        while(low<=high){
            int mid=low+(high-low)/2;
            if(arr[mid]==target){
                return mid+1;
            }else if(arr[mid]>target){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return -1;
    }
}
