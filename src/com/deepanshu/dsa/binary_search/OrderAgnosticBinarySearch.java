package com.deepanshu.dsa.binary_search;

public class OrderAgnosticBinarySearch {
    public static int binarySearch(int[] arr, int target) {
        int s = 0;
        int e = arr.length -1;
        boolean isAsc = arr[s] < arr[e];
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (arr[mid] == target) {
                return mid;
            }
            if (isAsc) {
                if (arr[mid] > target) {
                    e = mid -1;
                } else {
                    s = mid + 1;
                }
            } else {
                if (arr[mid] > target) {
                    s = mid + 1;
                } else {
                    e = mid - 1;
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) {
//        int[] arr = {1,2,3,4,5,6,6,7,8,9,10};
        int[] arr = {10,9,8,7,6,5,4,3,2,1};
        int target = 7;
        int ans = binarySearch(arr, target);
        System.out.println(ans == -1 ? "Element not found" : "Element found at index " + ans);
    }
}
