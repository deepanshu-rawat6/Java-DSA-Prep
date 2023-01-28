package com.deepanshu.foobar_google.challenge_1;

import java.util.Arrays;
import java.util.HashSet;

public class Solution {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{14, 27, 1, 4, 2, 50, 3, 1}, new int[]{2, 4, -4, 3, 1, 1, 14, 27, 50}));
    }

    public static int solution(int[] x,int[] y) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : x) {
            set.add(i);
        }
        for (int i : y) {
            if (!set.contains(i)) {
                return i;
            }
        }
        return 0;
    }
}
