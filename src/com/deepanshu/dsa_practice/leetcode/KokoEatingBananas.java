package com.deepanshu.dsa_practice.leetcode;

public class KokoEatingBananas {
    private static final int INT_MAX = 1000000000;

    public static void main(String[] args) {
        int[] piles = {3,6,7,11};
        int h = 8;

//        int[] piles = {30,11,23,4,20};
//        int h = 5;
//
//        int[] piles = {30,11,23,4,20};
//        int h = 6;

//        int[] piles = {312884470};
//        int h = 312884469;

        System.out.println(minEatingSpeed(piles, h));
    }
    public static int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 1;
        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        while (left < right) {
            int mid = left + (right - left) / 2;

            int temp_hr = 0;

             System.out.println("\nLeft: " + left + " Right: " + right);

            for (int pile : piles) {
                temp_hr += (int) Math.ceil((double) pile / mid);
                 System.out.println(temp_hr);
            }


             System.out.println("Mid: " + mid + " Temp_Hr: " + temp_hr);


            if (temp_hr <= h) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return right;
    }
}
