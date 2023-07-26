package com.deepanshu.dsa_practice.practice;
// Index of the last occurance of a target number in an array
public class Recursive {
    static int index = 0;
    static int ans = -1;
    public static void main(String[] args) {
        int[] arr = {1,3,4,5,6,7,3,6};
//        int index = 0;
        int target = 3;
//        int ans = 0;
        System.out.println(LastIndex(arr,target));
    }
    private static int LastIndex(int[] arr, int target) {
        if(index == arr.length) {
            return ans + 1;
        }
        if (arr[index] == target) {
            ans = index;
        }
        index += 1;
        return LastIndex(arr,target);
    }
}
