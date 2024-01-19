package com.deepanshu.dsa_practice.leetcode;

import com.deepanshu.dsa_practice.practice.HelloGoodbye;

import java.util.Arrays;

public class TrappingRainWater {
    public static void main(String[] args) {
//        int[] height = {4,2,0,3,2,5};
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
    }

//    Approach:1
//    public  static int trap(int[] height) {
//        if (height.length == 0) {
//            return 0;
//        }
//        int i = 0, j = height.length - 1;
//        int Lmax = height[i], Rmax = height[j];
//        int area = 0;
//
//        while (i < j) {
//            if (Lmax < Rmax) {
//                i++;
//                Lmax = Math.max(Lmax, height[i]);
//                area += Lmax - height[i];
//            } else {
//                j--;
//                Rmax = Math.max(Rmax, height[j]);
//                area += Rmax - height[j];
//            }
//        }
//
//        return area;
//    }

//    Approach:2
public  static int trap(int[] height) {
        if (height.length == 0) {
            return 0;
        }

        int[] leftMax = new int[height.length];
        int[] rightMax = new int[height.length];

        int Lmax = height[0];
        int Rmax = height[height.length - 1];
        int area = 0;

        for (int i = 0; i < height.length; i++) {
            if (Lmax < height[i]) {
                Lmax = height[i];
            }
            leftMax[i] = Math.max(Lmax, height[i]);
            rightMax[height.length - 1 - i] = Math.max(Rmax, height[height.length - 1]);
        }

        for (int i = height.length - 1; i >= 0; i--) {
            if (Rmax < height[i]) {
                Rmax = height[i];
            }
            rightMax[i] = Math.max(Rmax, height[i]);
        }

        for (int i = 0; i < height.length; i++) {
            if (leftMax[i] < rightMax[i]) {
                area += leftMax[i] - height[i];
            } else {
                area += rightMax[i] - height[i];
            }
        }

        return area;
    }
}
