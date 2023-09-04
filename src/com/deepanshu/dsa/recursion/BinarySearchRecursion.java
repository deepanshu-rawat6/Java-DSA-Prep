package com.deepanshu.dsa.recursion;

public class BinarySearchRecursion {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,7,8,9};
        int target = 5;
        System.out.println(binarySearch(arr,0,arr.length -1, target));
    }

    public static int binarySearch(int[] arr, int start, int end, int target) {
        if (start > end) {
            return -1;
        }
        int mid = start + (end - start) / 2;

        if (arr[mid] == target) {
            return mid;
        }

        if (target < arr[mid]) {
            return binarySearch(arr, start,mid - 1, target);
        }
        return binarySearch(arr,mid + 1, end, target);
    }
}
