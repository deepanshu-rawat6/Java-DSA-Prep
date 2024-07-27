package com.deepanshu.dsa_practice.leetcode.twopointers;

public class ContainerWithMostWater {
    public static void main(String[] args) {
//        int[] height = {1,8,6,2,5,4,8,3,7};

        int[] height = {1,1};

        System.out.println(maxArea(height));
    }

    public static int maxArea(int[] height) {
        int i = 0, j = height.length - 1, maxArea = 0;

        while (i < j) {
            maxArea = Math.max(maxArea, Math.min(height[i] , height[j]) * (j - i));

            if (height[i] > height[j]) {
                j--;
            } else {
                i++;
            }
        }

        return maxArea;
    }
}
