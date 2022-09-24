package com.deepanshu.practice;

import java.util.ArrayList;
import java.util.Arrays;
public class join_two_lists {
    public static void main(String[] args){
        ArrayList<Integer> l1=new ArrayList<Integer>();
        ArrayList<Integer> l2=new ArrayList<Integer>();
        ArrayList<Integer> ans=new ArrayList<Integer>();
        for(int i=1;i<=10;i++){
            if(i<=5) l1.add(i);
            else l2.add(i);
        }
        ans.addAll(l1);
        ans.addAll(l2);
        System.out.println("First List:"+l1);
        System.out.println("Second List:"+l2);
        System.out.print("Resultant list:"+ans);
    }
}
