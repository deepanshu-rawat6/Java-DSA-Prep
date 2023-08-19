package com.deepanshu.dsa.binary_search;

public class BinarySearchOnInfiniteArray {
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30};
        int target = 18;
        System.out.println(infiniteArray(arr, target));
    }

    public static int infiniteArray(int[] arr, int target) {
        int s = 0;
        int e = 1;
        while (target > arr[e]) {
            int newStart = e + 1;
            e = e + (e - s + 1) * 2;
            s = newStart;
        }
        return binarySearch(arr, s, e, target);
    }

    public static int binarySearch(int[] arr, int s, int e,int target) {
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (arr[mid] == target)
                return mid;
            else if (arr[mid] > target)
                e = mid - 1;
            else
                s = mid + 1;
        }
        return -1;
    }
}
