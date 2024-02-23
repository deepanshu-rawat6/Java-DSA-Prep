package com.deepanshu.dsa_practice.practice;

import java.util.Scanner;

public class FlowChart {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the fixed salary from the company: ");
        int sal_amt = sc.nextInt();
        double renumeration = 0, comission = 0;
        if (sal_amt > 5000) {
            comission = ((sal_amt - 5000) * 0.12);
        } else  {
            comission = 0;
        }
        renumeration = sal_amt + comission;
        System.out.println("Sales amount : " + sal_amt);
        System.out.println("Comission : " + comission);
        System.out.println("Renumeration: " + renumeration);
    }
}
