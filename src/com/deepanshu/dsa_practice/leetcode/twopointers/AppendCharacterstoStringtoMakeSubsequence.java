package com.deepanshu.dsa_practice.leetcode.twopointers;

public class AppendCharacterstoStringtoMakeSubsequence {
    public static void main(String[] args) {
        String s = "coaching", t = "coding";
//        String s = "abcde", t = "a";
//        String s = "z", t = "abcde";
        System.out.println(appendCharacters(s, t));
    }

    public static int appendCharacters(String s, String t) {
        int sIndx = 0, tIndx = 0;
        int sLen = s.length(), tLen = t.length();

        while (sIndx < sLen && tIndx < tLen) {
            if (s.charAt(sIndx) == t.charAt(tIndx)) {
                tIndx++;
            }
            sIndx++;
        }

        return tLen - tIndx;
    }
}
