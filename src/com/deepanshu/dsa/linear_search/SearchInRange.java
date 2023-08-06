package com.deepanshu.dsa.linear_search;

public class SearchInRange {
    public static int search(int[] arr, int target, int start, int end) {
        if (arr.length == 0) {
            return -1;
        }
        for (int i = start; i <= end; i++) {
            if (arr[i] == target)
                return i;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {12,31,3,12,4,124,12,52,6,34,67,45757};
        int target = 124;
        int start = 2;
        int end = 8;
        int ans = search(arr,target, start, end);
        System.out.println(ans == -1 ? "Element not found" : "Element found at index " + ans);
    }
}
