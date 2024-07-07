package com.deepanshu.dsa_practice.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinimumNumberofKConsecutiveBitFlips {
    public static void main(String[] args) {
        int[] nums = {0,0,0,1,0,1,1,0};
        int k = 3;
        System.out.println(minKBitFlips(nums, k));
    }

//    public static int minKBitFlips(int[] nums, int k) {
//        Deque<Integer> deque = new ArrayDeque<>();
//
//        int res = 0;
//
//        for (int i = 0; i < nums.length; i++) {
//            while (!deque.isEmpty() && i > deque.peekFirst() + k - 1) {
//                deque.pollFirst();
//            }
//
//            if ((nums[i] + deque.size()) % 2 == 0) {
//                if (i + k > nums.length) {
//                    return -1;
//                }
//                res += 1;
//                deque.add(i);
//            }
//        }
//
//        return res;
//    }

    public static int minKBitFlips(int[] nums, int k) {
        int res = 0;

        int curr_window_flips = 0;

        for (int i = 0; i < nums.length; i++) {
            if (i - k >= 0 && nums[i - k] == 2) {
                curr_window_flips -= 1;
            }

            if ((nums[i] + curr_window_flips) % 2 == 0) {
                if (i + k > nums.length) {
                    return -1;
                }
                res += 1;
                curr_window_flips += 1;
                nums[i] = 2;
            }
        }

        return res;
    }
}
