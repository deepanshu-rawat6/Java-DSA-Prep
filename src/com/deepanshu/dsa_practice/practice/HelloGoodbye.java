package com.deepanshu.dsa_practice.practice;

import java.util.Scanner;

public class HelloGoodbye {
    public static void main(String[] args){
        String str1,str2;
        Scanner sc=new Scanner(System.in);
        str1=sc.next();
        str2=sc.next();
        System.out.println("Hello "+str1+" and "+str2);
        System.out.println("Goodbye "+str2+" and "+str1);
    }
}
