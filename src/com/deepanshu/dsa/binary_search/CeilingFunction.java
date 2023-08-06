package com.deepanshu.dsa.binary_search;

public class CeilingFunction {
    public static void main(String[] args) {
        int[] arr = {2,3,5,9,14,16,18};
        int target = 7;
        System.out.println("Ceiling of " + target + " is " + ceiling(arr, target));
    }

    public static int ceiling(int[] arr,int target) {
        int s = 0;
        int e = arr.length - 1;
        while (s < e) {
            int mid  = s + (e - s) / 2;
            if (arr[mid] < target) {
                s = mid + 1;
            } else {
                e = mid;
            }
        }
        return arr[e];
    }
}

// Logic:
/*

 */
