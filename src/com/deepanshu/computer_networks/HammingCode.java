package com.deepanshu.computer_networks;

import java.util.*;

public class HammingCode {


    public static int[] generateHammingCode(int[] data) {


        int r = 0;
        while (Math.pow(2, r) < data.length + r + 1) {
            r++;
        }


        int[] hammingCode = new int[data.length + r];


        int j = 0;
        for (int i = 0; i < hammingCode.length; i++) {
            if (Math.pow(2, j) - 1 == i) {
                j++;
            } else {
                hammingCode[i] = data[i - j];
            }
        }


        for (int i = 0; i < r; i++) {
            int parityIndex = (int) Math.pow(2, i) - 1;
            int parity = 0;
            for (j = parityIndex; j < hammingCode.length; j += (parityIndex + 1) * 2) {
                for (int k = j; k <= j + parityIndex && k < hammingCode.length; k++) {
                    parity ^= hammingCode[k];
                }
            }
            hammingCode[parityIndex] = parity;
        }

        return hammingCode;
    }

    // Method to decode Hamming Code
    public static int[] decodeHammingCode(int[] hammingCode) {

        int r = 0;
        while (Math.pow(2, r) < hammingCode.length) {
            r++;
        }


        int[] parityBits = new int[r];
        for (int i = 0; i < r; i++) {
            int parityIndex = (int) Math.pow(2, i) - 1;
            int parity = 0;
            for (int j = parityIndex; j < hammingCode.length; j += (parityIndex + 1) * 2) {
                for (int k = j; k <= j + parityIndex && k < hammingCode.length; k++) {
                    parity ^= hammingCode[k];
                }
            }
            parityBits[i] = parity;
        }


        int errorIndex = 0;
        for (int i = 0; i < r; i++) {
            errorIndex += parityBits[i] * Math.pow(2, i);
        }
        if (errorIndex != 0) {
            hammingCode[errorIndex - 1] ^= 1;
        }


        int[] data = new int[hammingCode.length - r];
        int j = 0;
        for (int i = 0; i < hammingCode.length; i++) {
            if (Math.pow(2, j) - 1 != i) {
                data[i - j] = hammingCode[i];
            } else {
                j++;
            }
        }

        return data;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);


        System.out.print("Enter data bits: ");
        String dataStr = sc.nextLine().trim().replaceAll("\\s", "");
        int[] data = new int[dataStr.length()];
        for (int i = 0; i < data.length; i++) {
            data[i] = Integer.parseInt(String.valueOf(dataStr.charAt(i)));
        }

        int[] hammingCode = generateHammingCode(data);
        System.out.println("Generated Hamming Code: " + Arrays.toString(hammingCode));

        int[] decodedData = decodeHammingCode(hammingCode);
        System.out.println("Decoded data: " + Arrays.toString(decodedData));
    }

}

// TESTCASE: 1011
