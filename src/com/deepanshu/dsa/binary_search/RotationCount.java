package com.deepanshu.dsa.binary_search;

//import static com.deepanshu.dsa_practice.leetcode.RotatedBinarySearch.findPivot;

public class RotationCount {
    public static void main(String[] args) {
        int[] arr = {10,12,2,3,4,5,7,8,9};
//        int[] arr = {1,2,3,4,5,6,7};
//        If the value obtained is 0, that means the array is not rotated at all.
        System.out.println(findRotationCount(arr));
    }

    public static int findRotationCount(int[] arr) {
        int pivot = findPivotElement(arr);
        return pivot + 1;
    }

    public static int findPivotElement(int[] arr) {
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
}
