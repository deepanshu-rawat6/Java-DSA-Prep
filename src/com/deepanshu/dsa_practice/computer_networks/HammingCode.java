package com.deepanshu.dsa_practice.computer_networks;

import java.util.*;

public class HammingCode {

    public void compute() {
        int[] data = new int[4];
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the data bits:");
        for (int i = 0; i < 4; i++) {
            data[i] = sc.nextInt();
        }
        int[] final_code = new int[7];
        final_code[0] = data[0];
        final_code[1] = data[1];
        final_code[2] = data[2];
        final_code[4] = data[3];
        final_code[3] = final_code[0] ^ final_code[1] ^ final_code[2];
        final_code[5] = final_code[0] ^ final_code[1] ^ final_code[4];
        final_code[6] = final_code[0] ^ final_code[2] ^ final_code[4];
        System.out.println("Data Bits:");
        System.out.println(Arrays.toString(data));
        System.out.println("Hamming Code:");
        System.out.println(Arrays.toString(final_code));
    }

    public static void main(String[] args) {
        HammingCode obj = new HammingCode();
        obj.compute();
    }

}

// TESTCASE: 1011
