package com.deepanshu.dsa.recursionl3strings;

import java.util.HashSet;

public class Permutations {
    public static void main(String[] args) {
        permutations("","122");
        System.out.println(set);
    }
    static HashSet<String> set=new HashSet<>();
    static void permutations(String p,String up){
        if(up.isEmpty()){
            set.add(p);
            return;
        }
        char ch=up.charAt(0);
        for(int i=0;i<=p.length();i++){
            String first=p.substring(0,i);
            String second=p.substring(i,p.length());
            permutations(first+ch+second,up.substring(1));
        }
    }
}