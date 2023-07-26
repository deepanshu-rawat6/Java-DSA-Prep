package com.deepanshu.dsa_practice.cybernetics_test.t2;

import java.util.Scanner;

public class Safe_Prime_Product {
    static boolean isPrime(int n){
        if(n<=1) return false;
        int i=2;
        while(i*i<=n){
            if(n%i==0) return false;
            i++;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int []A = new int[n];
        int []B = new int[n];
        for (int i = 0; i < n ; i++) {
            A[i] = sc.nextInt();
        }
        for (int i = 0; i < n ; i++) {
            B[i] = sc.nextInt();
        }
        int P = sc.nextInt();
        for (int i = 0; i < n; i++) {
            if (isPrime(A[i]) && isPrime(B[i])) {
                System.out.print("0 ");
            } else if (A[i] == 1 && B[i] == 1) {
                System.out.print("0 ");
            } else if (A[i] == 1) {
                System.out.print(B[i] + " ");
            } else if (B[i] == 1) {
                System.out.print(A[i] + " ");
            } else if (isPrime(A[i])){
                System.out.print(B[i] + " ");
            } else {
                System.out.print(A[i] + " ");
            }
        }
    }
}


