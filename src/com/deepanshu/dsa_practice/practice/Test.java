package com.deepanshu.dsa_practice.practice;

import java.util.Scanner;

class UserDefined extends Exception {
    UserDefined() {
        System.out.println("Please enter valid marks");
    }
}
public class Test{
    public void compute() throws UserDefined {
        Scanner sc = new Scanner(System.in);
        int[] marks = new int[10];
        for(int i = 0; i < 10; i++) {
            marks[i] = sc.nextInt();
            if (marks[i] < 0 || marks[i] >100) {
                throw new UserDefined();
            }
        }
    }
    public static void main(String[] args) throws UserDefined {
        Test obj = new Test();
        obj.compute();
    }
}
