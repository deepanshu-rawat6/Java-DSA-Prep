package com.deepanshu.dsa_practice.computer_networks;

import java.util.*;

public class CyclicRedundencyCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] data;
        int[] divisor;
        int[] remainder;
        int data_bits, divisor_bits, tot_length;

        System.out.print("Enter number of data bits : ");
        data_bits = sc.nextInt();
        data = new int[data_bits];

        System.out.print("Enter data bits : ");
        for (int i = 0; i < data_bits; i++) {
            data[i] = sc.nextInt();
        }

        System.out.print("Enter number of bits in divisor : ");
        divisor_bits = sc.nextInt();
        divisor = new int[divisor_bits];

        System.out.print("Enter Divisor bits : ");
        for (int i = 0; i < divisor_bits; i++) {
            divisor[i] = sc.nextInt();
        }

        tot_length = data_bits + divisor_bits - 1;
        remainder = new int[tot_length];

        System.arraycopy(data, 0, remainder, 0, data.length);

        System.out.print("Data is : ");
        for (int datum : data) {
            System.out.print(datum);
        }

        System.out.print("\nDivisor is : ");
        for (int value : divisor) {
            System.out.print(value);
        }

        for (int j = 0; j < data.length; j++) {
            if (remainder[j] == 1) {
                for (int k = 0; k < divisor.length; k++) {
                    remainder[j + k] ^= divisor[k];
                }
            }
        }

        System.out.print("\nRemainder is : ");
        for (int j : remainder) {
            System.out.print(j);
        }

        System.arraycopy(data, 0, remainder, 0, data_bits);

        System.out.print("\nFinal Data Steam: ");
        for (int j: remainder) {
            System.out.print(j);
        }
    }
}
