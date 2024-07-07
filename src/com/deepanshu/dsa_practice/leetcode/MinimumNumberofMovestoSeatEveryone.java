package com.deepanshu.dsa_practice.leetcode;

import java.time.chrono.IsoEra;
import java.util.Arrays;

public class MinimumNumberofMovestoSeatEveryone {
    public static void main(String[] args) {
        int[] seats = {3,1,5}, students = {2,7,4};
        System.out.println(minMovesToSeat(seats, students));
    }

//    public static int minMovesToSeat(int[] seats, int[] students) {
//        Arrays.sort(seats);
//        Arrays.sort(students);
//
//        int moves = 0;
//        for (int i = 0; i < seats.length; i++) {
//            moves += Math.abs(students[i] - seats[i]);
//        }
//
//        return moves;
//    }

    public static int minMovesToSeat(int[] seats, int[] students) {
        int[] freqArr = new int[101];

        for (int i = 0; i < seats.length; i++) {
            freqArr[seats[i]]++;
            freqArr[students[i]]--;
        }

        int moves = 0;
        int curr = 0;
        for (int i : freqArr) {
            moves += Math.abs(curr);
            curr += i;
        }

        return moves;
    }
}
