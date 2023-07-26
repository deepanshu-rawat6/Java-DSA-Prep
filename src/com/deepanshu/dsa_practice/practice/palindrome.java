package com.deepanshu.dsa_practice.practice;

import java.util.Scanner;
public class palindrome {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String str=sc.next();
        if(check_palindrome(str)) System.out.println(str +" is a com.deepanshu.dsa_practice.practice.palindrome string!");
        else System.out.println(str +" is not a com.deepanshu.dsa_practice.practice.palindrome string!");
    }
    public static boolean check_palindrome(String str){
        int len=str.length();
        for(int i=0;i<len/2;i++){
            char ch=str.charAt(i);
            char chr=str.charAt(len-1-i);
            if(ch!=chr){
                return false;
            }
        }
        return true;
    }
}
