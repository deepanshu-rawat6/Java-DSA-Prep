package com.deepanshu.dsa.recursionl1;

public class MaxAndMinElement {

    public static int maxElement(int[] arr, int x, int max) {
        if (x == arr.length) {
            return max;
        }

        if (max < arr[x]) {
            max = arr[x];
            return maxElement(arr, x + 1, max);
        }
        return maxElement(arr, x + 1, max);
    }
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,56};
        System.out.println(maxElement(arr,0, 0));
    }
}
