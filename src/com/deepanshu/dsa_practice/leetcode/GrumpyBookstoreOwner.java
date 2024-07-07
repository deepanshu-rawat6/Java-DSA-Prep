package com.deepanshu.dsa_practice.leetcode;

import java.util.Arrays;

public class GrumpyBookstoreOwner {
    public static void main(String[] args) {
        int[] customers = {1,0,1,2,1,1,7,5}, grumpy = {0,1,0,1,0,1,0,1};
        int minutes = 3;

        System.out.println(maxSatisfied(customers, grumpy, minutes));
    }

    public static int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int i = 0, j = 0, maxCustomers = 0, tempCustomers = 0, res = 0;

//        Simply, maximum subarray sum
        while (j < customers.length) {
            tempCustomers += customers[j] * grumpy[j];

            if (j - i + 1 == minutes) {
                maxCustomers = Math.max(maxCustomers, tempCustomers);
                tempCustomers -= customers[i] * grumpy[i];
                i++;
            }
            j++;
        }

        res = maxCustomers;

//        For getting the satisfied ones
        for (int k = 0; k < customers.length; k++) {
            res += customers[k] * (1 - grumpy[k]);
        }

        return res;
    }
}
