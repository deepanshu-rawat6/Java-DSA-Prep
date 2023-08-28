package com.deepanshu.dsa_practice.leetcode;

public class RotatedBinarySearch {
    public static void main(String[] args) {
        int[] arr = {10,12,2,4,5,7,8,9};
        System.out.println(searchRotatedArray(arr, 2));
    }

    public static int searchRotatedArray(int[] arr, int target) {
        int pivot = findPivot(arr);

        if (pivot == -1) {
            return searchBS(arr, 0, arr.length - 1, target);
        }

        if (arr[pivot] == target) {
            return pivot;
        }

        if (target >= arr[0]) {
            return searchBS(arr, 0, pivot - 1, target);
        }

        return searchBS(arr, pivot + 1, arr.length - 1, target);
    }

    public static int findPivot(int[] arr) {
        int s = 0;
        int e = arr.length - 1;
        while (s <= e) {
            int mid = s + (e - s) / 2;

            if (mid < e && arr[mid] > arr[mid + 1]) {
                return mid;
            } else if (mid > s && arr[mid] < arr[mid - 1]) {
                return mid - 1;
            } else if (arr[s] >= arr[mid]) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return -1;
    }

    public static int searchBS(int[] arr, int s, int e, int target) {
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (arr[mid] >  target) {
                e = mid - 1;
            } else if (arr[mid] < target) {
                s = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}

