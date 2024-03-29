package com.deepanshu.dsa.binary_search;

public class CeilingFunction {
    public static void main(String[] args) {
        int[] arr = {2,3,5,9,14,16,17,18};
        int target = 15;
        System.out.println("Ceiling of " + target + " is " + ceiling(arr, target));
    }

//    public static int ceiling(int[] arr,int target) {
//        int s = 0;
//        int e = arr.length - 1;
//        while (s < e) {
//            int mid  = s + (e - s) / 2;
//            if (arr[mid] < target) {
//                s = mid + 1;
//            } else {
//                e = mid;
//            }
//        }
//        return arr[e];
//    }

    public static int ceiling(int[] arr, int target)  {
        int s = 0;
        int e = arr.length - 1;
        while (s <= e) {
            int mid = s + (e - s) / 2;
            if (arr[mid] == target) {
                return arr[mid];
            } else if (arr[mid] < target) {
                s = mid + 1;
            } else {
                e = mid - 1;
            }
        }
        return arr[s];
    }
}

// Logic:
/*

 */
