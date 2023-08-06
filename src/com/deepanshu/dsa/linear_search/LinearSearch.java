package com.deepanshu.dsa.linear_search;

public class LinearSearch {
    public static int linearSearch(int[] arr, int target) {
        for (int i =0; i < arr.length; i++) {
            if (arr[i] == target)
                return i;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr ={1023,12,31,23,12,3,14,21,4,124,12,41,4124,12410};
        int target = 14;
//        int target = 0;
        int ans = linearSearch(arr, target);
        System.out.println(ans == -1 ? "Element not found" : "Element found at index " + ans);
    }
}
