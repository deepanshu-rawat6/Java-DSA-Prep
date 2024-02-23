package com.deepanshu.dsa.recursionl5strings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class Permutations {
    public static void main(String[] args) {
//        permutations("","abc");
//        System.out.println(set);
        System.out.println(permute("abc"));
    }
    static HashSet<String> set = new HashSet<>();
    static void permutations(String p,String up){
        if(up.isEmpty()){
            set.add(p);
            return;
        }
        char ch = up.charAt(0);
        for(int i = 0; i <= p.length(); i++){
            String first = p.substring(0, i);
            String second = p.substring(i);
            permutations(first + ch + second, up.substring(1));
        }
    }

    static List<String> permute(String unprocessed) {
        List<String> res = new ArrayList<>();
        backtract(res, new StringBuilder(), unprocessed, 0);
        return res;
    }

    static void backtract(List<String> res, StringBuilder sb, String unprocessed, int count) {
        if (sb.length() == unprocessed.length()) {
            res.add(sb.toString());
        } else {
            for (char chr : unprocessed.toCharArray()) {
                if (sb.indexOf(String.valueOf(chr)) != -1) {
                    continue;
                }
                sb.append(chr);
                backtract(res, sb, unprocessed, count);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}