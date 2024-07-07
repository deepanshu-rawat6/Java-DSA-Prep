package com.deepanshu.dsa_practice.leetcode;

public class WaterBottles {

    public static void main(String[] args) {

        System.out.println(numWaterBottles(15, 4));
    }

    public static int numWaterBottles(int numBottles, int numExchange) {
        int res = numBottles, extraB = 0;

        while (numBottles != 0) {
            extraB = numBottles % numExchange;
            numBottles /= numExchange;
            res += numBottles;
            numBottles += extraB;
            if (numBottles < numExchange) break;
        }
        return res;
    }
}
