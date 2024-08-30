package com.deepanshu.dsa_practice.practice.DEShaw;

import java.util.Arrays;

public class GetMinRemoval {
    public static void main(String[] args) {
        String str = "solidandliquid";
        int k = 1;
        System.out.println(minRemove(str, k));
    }

    public static int minRemove(String str, int k) {
        int[] freq = new int[26];
        int res = 0;

        for (char c : str.toCharArray()) {
            freq[c - 'a']++;
        }

        Arrays.sort(freq);

        int i = 0, j = 25;
        while (i <= j) {
            if (freq[i] == 0) i++;
            else if (freq[j] == 0) j--;
            else {
                int abs = Math.abs(freq[i] - freq[j]);
                if (abs > k) {
                    res += abs - k;
                }
                j--;
            }
        }

        return res;
    }
}
