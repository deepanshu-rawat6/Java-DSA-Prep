package com.deepanshu.dsa.binary_search;

public class MountainArray {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,9,8,7};
        System.out.println("Peak element is " + peakElement(arr));
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
}
