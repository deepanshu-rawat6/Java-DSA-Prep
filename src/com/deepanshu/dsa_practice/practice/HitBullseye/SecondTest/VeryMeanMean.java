package com.deepanshu.dsa_practice.practice.HitBullseye.SecondTest;

import java.util.HashMap;
import java.util.Scanner;

public class VeryMeanMean {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] arr = new long[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }

        System.out.println(compute(arr, n));
    }

    public static long compute(long[] arr, int n) {
        long sum = 0;

        if (n < 3) {
            System.out.println(0);
            return -1;
        }

        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }

        HashMap<Long, Integer> countMap = new HashMap<>();
        for (long num : arr) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        long pairs = 0;
        for (long num : arr) {
            long targetSum = 2 * sum - 2 * num;
            if (targetSum % (n - 2) == 0) {
                long needed = targetSum / (n - 2);
                if (countMap.containsKey(needed)) {
                    if (needed == num) {
                        // If needed is the same as num, we need to subtract one to avoid counting the element itself
                        pairs += countMap.get(needed) - 1;
                    } else {
                        pairs += countMap.get(needed);
                    }
                }
            }
        }

        return pairs / 2;
    }
}
