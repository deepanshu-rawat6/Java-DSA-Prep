package com.deepanshu.java.functions;

import java.util.Scanner;

public class Armstrong {

    public boolean compute(int n) {
        int temp = n;
        int c = digits(temp);
//        System.out.println(c);
        int compute_num = 0;
        do {
            int r = temp % 10;
            compute_num = compute_num + (int)Math.pow(r,c);
            temp /= 10;
        } while(temp != 0);
//        System.out.println(compute_num);
        return n == compute_num;
    }

    public int digits(int num) {
        return (int)Math.log10(num) + 1;
    }
    public static void main(String[] args) {
        Armstrong obj = new Armstrong();
        Scanner sc = new Scanner(System.in);


//        int n = sc.nextInt();
//        System.out.println(obj.compute(n));


        int n = sc.nextInt();
        int m = sc.nextInt();

        while(n <= m) {
            if (obj.compute(n)) {
                System.out.print(n + " ");
            }
            n++;
        }
    }
}
