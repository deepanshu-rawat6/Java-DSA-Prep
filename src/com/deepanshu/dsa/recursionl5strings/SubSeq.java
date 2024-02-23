package com.deepanshu.dsa.recursionl5strings;

import java.util.ArrayList;
import java.util.HashSet;

public class SubSeq {
    public static void main(String[] args) {
//        subseq("","abc");
//        System.out.println(subseq1("","123"));
//        subseqASCII("","ab");
//        System.out.println();
//        System.out.println(set);
        System.out.println(subseq1ASCII("","abc"));
//        subset("", "abc");
    }

    static void subset(String p , String up) {
        if (up.isEmpty()) {
            System.out.println(p);
            return;
        }

        char ch = up.charAt(0);
        subset(p + ch, up.substring(1));
        subset(p, up.substring(1));
    }

//    static void subseq(String p,String up){
//        if(up.isEmpty()){
//            System.out.println(p);
//            return;
//        }
//        char ch=up.charAt(0);
//        subseq(p+ch,up.substring(1));
//        subseq(p,up.substring(1));
//    }

    static ArrayList<String> subseq1(String p, String up) {
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<String>();
            list.add(p);
            return list;
        }
        char ch = up.charAt(0);
        ArrayList<String> left = subseq1(p + ch, up.substring(1));
        ArrayList<String> right = subseq1(p, up.substring(1));
        left.addAll(right);
        return left;
    }
    static HashSet<String> set = new HashSet<String>();
    static void subseqASCII(String p,String up){
        if(up.isEmpty()){
            System.out.println(p);
            set.add(p);
            return;
        }
        char ch = up.charAt(0);
        subseqASCII(p + ch, up.substring(1));
        subseqASCII(p, up.substring(1));
        subseqASCII(p + (ch + 0), up.substring(1));
    }
    static ArrayList<String> subseq1ASCII(String p, String up){
        if(up.isEmpty()){
            ArrayList<String> list = new ArrayList<String>();
            list.add(p);
            return list;
        }
        char ch = up.charAt(0);
        ArrayList<String> first = subseq1ASCII(p + ch, up.substring(1));
        ArrayList<String> second = subseq1ASCII(p , up.substring(1));
        ArrayList<String> third = subseq1ASCII(p + (ch + 0), up.substring(1));
        first.addAll(second);
        first.addAll(third);
        return first;
    }


}
