package com.deepanshu.dsa_practice.leetcode;

import java.util.HashMap;
import java.util.Map;

public class CheckOddDigits {
    public static void main(String[] args){
        String str = "34154536819787916";
        helper(str);
    }

    public static void helper(String str) {
        Map<Character, Integer> count = new HashMap<>();
        for (char chr : str.toCharArray()){
            count.put(chr, count.getOrDefault(chr, 0) + 1);
        }

        for(Map.Entry<Character, Integer> entry: count.entrySet()){
            if(entry.getValue() % 2 != 0){
                System.out.println(entry.getKey());
                return;
            }
        }
    }
}
