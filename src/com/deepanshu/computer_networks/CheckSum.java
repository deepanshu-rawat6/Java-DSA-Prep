package com.deepanshu.computer_networks;

import java.util.*;

public class CheckSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of data bits:");
        int n = sc.nextInt();
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter the data bit:");
            data[i] = sc.nextInt();
        }
        int checksum = computeChecksum(data);
        System.out.printf("\nChecksum: " + checksum);
    }

    public static int computeChecksum(int[] data) {
        int sum = 0;
        for (int value : data) {
            sum += value;
        }
        int checksum = sum & 0xFF; // 0xFF = 11111111
        return checksum;
    }
}

