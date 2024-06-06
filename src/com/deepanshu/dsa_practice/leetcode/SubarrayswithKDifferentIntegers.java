package com.deepanshu.dsa_practice.leetcode;

import java.util.HashMap;

public class SubarrayswithKDifferentIntegers {
    public static void main(String[] args) {
        int[] nums = {1,2,1,2,3};
        int k = 2;
        System.out.println(subarraysWithKDistinct(nums, k));
    }

    public static int subarraysWithKDistinct(int[] nums, int k) {
        int l_n = 0, l_f = 0, res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);

            while (map.size() > k) {
                if (map.containsKey(nums[l_n])) {
                    map.put(nums[l_n], map.get(nums[l_n]) - 1);
                    if (map.get(nums[l_n]) == 0) {
                        map.remove(nums[l_n]);
                    }
                    l_n += 1;
                    l_f = l_n;
                }
            }

            while (map.containsKey(nums[l_n]) && map.get(nums[l_n]) > 1) {
                map.put(nums[l_n], map.get(nums[l_n]) - 1);
                l_n += 1;
            }

            if (map.size() == k) {
                res += l_n - l_f + 1;
            }
        }

        return res;
    }
}
