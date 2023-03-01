package com.deepanshu.computer_networks;

import java.util.Scanner;

public class BitStuffing {
    static final String flag = "01111110";  // A default flag
    private String compute(String bits){
        int c = 0;
        StringBuilder sb = new StringBuilder();
        for (char i:bits.toCharArray()) {
            sb.append(i);
            if (i == '1') {
                c++;
            } else {
                c = 0;
            }

            if (c == 5) {
                sb.append('0');
                c = 0;
            }
        }
        return sb.toString();
    }
    private void display() {
        Scanner sc = new Scanner(System.in);
        System.out.println("The default flag for bit stuffing: " + flag);
        System.out.println("Enter the stream of bits:");
        String bits = sc.next();
        String stuffedBits = compute(bits);
        System.out.println("\nStuffed stream of bits:\n");
        System.out.println(flag + " | " + stuffedBits + " | " + flag);
    }
    public static void main(String[] args) {
        BitStuffing obj = new BitStuffing();
        obj.display();
    }
}
