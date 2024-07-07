package com.deepanshu.dsa_practice.leetcode.slidingwindow.fixedsized;

import java.util.*;

public class FirstNegativeNumberInEveryWindowofSizeK {
    public static void main(String[] args) {
//        int[] nums = {12, -1, -7, 8, -15, 30, 16, 28};
//        int k = 3;

//        int[] nums = {-1, 2, 6, -5, -4};
//        int k = 2;

        int[] nums = {8, 6, -9, 0, 0, -1, 0};
        int k = 3;
        System.out.println(Arrays.toString(firstNegative(nums, nums.length, k)));
    }

    public static int[] firstNegative(int[] nums, int n, int k) {
        Deque<Integer> Di = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();

        int i;
        for (i = 0; i < k; i++)
            if (nums[i] < 0) Di.addLast(i);

        for (; i < n; i++) {
            if (!Di.isEmpty()) ans.add(nums[Di.peekFirst()]);
            else ans.add(0);

            while ((!Di.isEmpty()) && Di.peekFirst() < (i - k + 1))
                Di.removeFirst();

            if (nums[i] < 0) Di.addLast(i);
        }

        if (!Di.isEmpty()) ans.add(nums[Di.peekFirst()]);
        else ans.add(0);

        // Convert ArrayList<Integer> to int[]
        int[] result = new int[ans.size()];
        for (i = 0; i < ans.size(); i++) {
            result[i] = ans.get(i);
        }

        return result;
    }
}
