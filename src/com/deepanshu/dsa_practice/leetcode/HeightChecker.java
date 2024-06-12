package com.deepanshu.dsa_practice.leetcode;

import java.util.Arrays;

public class HeightChecker {
    public static void main(String[] args) {
//        int[] heights = {1,1,4,2,1,3};
        int[] heights = {5,1,2,3,4};
        System.out.println(heightChecker(heights));
    }

    public static int maxInArr(int[] heights) {
        int max = 0;

        for (int i : heights) {
            max = Math.max(max, i);
        }
        return max;
    }

    public static int[] countingSort(int[] heights) {
        int max = maxInArr(heights);
        int[] freqArr = new int[max + 1];

        for (int i : heights) {
            freqArr[i]++;
        }

        int[] expected = new int[heights.length];

        int indx = 0;
        for (int i = 0; i <= max; i++) {
            while (freqArr[i] != 0) {
                expected[indx] = i;
                indx++;
                freqArr[i]--;
            }
        }

        return expected;
    }

    public static int heightChecker(int[] heights) {
        int max = maxInArr(heights);
        int[] freqArr = new int[max + 1];

        for (int i : heights) {
            freqArr[i]++;
        }

        int res = 0, currHeight = 0;

        for (int i = 0; i < heights.length; i++) {
            while (freqArr[currHeight] == 0) {
                currHeight++;
            }

            if (currHeight != heights[i]) {
                res++;
            }

            freqArr[currHeight]--;
        }

        return res;
    }

//    public static int heightChecker(int[] heights) {
//        int[] expected = countingSort(heights);
//
//        int res = 0;
//
//        for (int i = 0; i < heights.length; i++) {
//            res += (expected[i] != heights[i]) ? 1 : 0;
//        }
//
//        return res;
//    }

//    public static int heightChecker(int[] heights) {
//        int[] expected = Arrays.copyOf(heights, heights.length);
//
//        Arrays.sort(expected);
//
//        int res = 0;
//
//        for (int i = 0; i < heights.length; i++) {
//            res += (expected[i] != heights[i]) ? 1 : 0;
//        }
//
//        return res;
//    }
}
