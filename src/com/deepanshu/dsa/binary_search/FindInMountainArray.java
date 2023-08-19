package com.deepanshu.dsa.binary_search;

public class FindInMountainArray {
    public static void main(String[] args) {
        int []arr = {1,2,4,5,3,1};
        int target = 3;
        System.out.println("Element found at index " + findInMountainArray(arr, target));
    }

    public static int findInMountainArray(int[] arr,int target) {
        int peak = peakElement(arr);
        int firstTry = -1;
        firstTry = binarySearch(arr, target, 0, peak);
        if (firstTry == -1) {
            return binarySearch(arr, target, peak + 1, arr.length - 1);
        } else {
            return firstTry;
        }
    }

    public static int peakElement(int[] arr) {
        int s = 0;
        int e = arr.length - 1;
        while (s < e) {
            int mid = s + (e - s) / 2;
            if (arr[mid] > arr[mid + 1]) {
                e = mid;
            } else {
                s = mid + 1;
            }
        }
        return s;
    }
    public static int binarySearch(int[] arr, int target, int s, int e) {
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
}
