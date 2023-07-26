package com.deepanshu.dsa.bitwiseoperators;

import java.util.Scanner;

public class calculate_a_raised_to_the_power_b {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        int ans=1;
        while(b>0){
            if((b&1)==1){
                ans*=ans*a;
            }
            a*=a;
            b>>=1;
        }
        System.out.println(ans);
    }
}
