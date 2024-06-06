package com.deepanshu.dsa_practice.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestPalindrome {
    public static void main(String[] args) {
//        String s = "abccccdd";
//        String s = "AAAA";
//        String s = "aaaAaaaa";
        String s = "civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth";
        System.out.println(longestPalindrome(s));
    }

    public static int longestPalindrome(String s) {

//        HashMap<Character, Integer> map = new HashMap<>();
////        int[] charCount = new int[128];
//
//        int res = 0, oddMax = 0;
//
//        for (char chr : s.toCharArray()) {
////            if (Character.isUpperCase(chr)) {
////                charCount[chr - 'A']++;
////            } else {
////                charCount[chr - 'a']++;
////            }
//
//            map.put(chr, map.getOrDefault(chr, 0) + 1);
//        }
//
////        for (int i = 0; i < 128; i++) {
////            if (charCount[i] == 0) continue;
////            else if (charCount[i] % 2 == 0) {
////                res += charCount[i];
////            } else {
////                oddMax = Math.max(oddMax, charCount[i]);
////            }
////        }
//
//        System.out.println(map);
//
//        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
//            if (entry.getValue() % 2 == 0) {
//                res += entry.getValue();
//            } else {
//                oddMax = Math.max(oddMax, entry.getValue());
//            }
//        }
//
//        res += oddMax;
//
//        return res;

        int[] charCount = new int[128];
        int oddCount = 0;

        for (char chr : s.toCharArray()) {
            charCount[chr]++;
            if (charCount[chr] % 2 == 1) {
                oddCount++;
            } else {
                oddCount--;
            }
        }

        return (oddCount > 1) ? s.length() - oddCount + 1 : s.length();
    }
}
