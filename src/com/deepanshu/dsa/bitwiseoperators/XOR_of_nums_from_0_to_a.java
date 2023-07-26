package com.deepanshu.dsa.bitwiseoperators;

import java.util.Scanner;

public class XOR_of_nums_from_0_to_a {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int ans=0;
        if(n%4==0) ans=n;
        else if(n%4==1) ans=1;
        else if(n%4==2) ans=n+1;
        else ans=0;
        System.out.println(ans);
    }
    
}
