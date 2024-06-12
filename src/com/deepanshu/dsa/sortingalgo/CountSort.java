package com.deepanshu.dsa.sortingalgo;

import java.util.Arrays;

public class CountSort {
    public static void main(String[] args) {
        int[] nums = {7,8,9,10,11,2,3,4,5,6,7,2,3,4,5,6,7};
        countingSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static int maxInArray(int[] nums) {
        int max = 0;

        for (int i : nums) {
            max = Math.max(max, i);
        }

        return max;
    }

    public static void countingSort(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }

        int max = maxInArray(nums);

        int[] freqArr = new int[max + 1];

        for (int i : nums) {
            freqArr[i]++;
        }

        System.out.println(Arrays.toString(freqArr));

        int indx = 0;
        for (int i = 0; i <= max; i++) {
            while (freqArr[i] != 0) {
                nums[indx] = i;
                indx++;
                freqArr[i]--;
            }
        }

        return;
    }
}
