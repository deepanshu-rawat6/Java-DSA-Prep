package com.deepanshu.dsa.binary_search;

public class FloorFunction {
    public static void main(String[] args) {
        int[] arr = {2,3,5,9,13,16,17,18};
        int target = 15;
        System.out.println("Floor of " + target + " is " + floor(arr, target));
    }

    public static int floor(int[] arr, int target) {
        int s = 0;
        int e = arr.length - 1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (arr[mid] == target) {
                return arr[mid];
            } else if (arr[mid] > target) {
                e = mid - 1;
            } else {
                s = mid + 1;
            }
        }
        return arr[e];
    }
}
