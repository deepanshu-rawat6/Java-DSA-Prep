package com.deepanshu.leetcode;

public class ValidPalindrome {
//    public static boolean isPalindrome(String s){
//        int i = 0;
//        int j = s.length() - 1;
//        while (i  < j) {
//            char ch = Character.toLowerCase(s.charAt(i));
//            char chr = Character.toLowerCase(s.charAt(j));
//            if (((ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9')) && ((chr >= 'a' && chr <= 'z') || (chr >= '0' && chr <= '9')) ) {
//                if (chr == ch) {
//                    i ++;
//                    j --;
//                    continue;
//                } else {
//                    return false;
//                }
//            } else {
//                if (!Character.isAlphabetic(ch)) {
//                    i ++;
//                    continue;
//                } else if (!Character.isAlphabetic(chr)){
//                    j --;
//                    continue;
//                }
//            }
//        }
//        return true;
//    }

    public static boolean isPalindrome(String s) {
        if (s.isEmpty()) {
            return true;
        }
        int head = 0;
        int tail = s.length() - 1;
        char cHead;
        char cTail;
        while (head <= tail) {
            cHead = s.charAt(head);
            cTail = s.charAt(tail);
            if (!Character.isLetterOrDigit(cHead)) {
                head++;
            } else if (!Character.isLetterOrDigit(cTail)) {
                tail--;
            } else {
                if (Character.toLowerCase(cHead) != Character.toLowerCase(cTail)) {
                    return false;
                }
                head++;
                tail--;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        String str = "A man, a plan, a canal: Panama";
        String str2 = "race a car";
        System.out.println(isPalindrome(str));
        System.out.println(isPalindrome(str2));
        System.out.println(isPalindrome(" "));
        System.out.println(isPalindrome("a."));
        System.out.println(isPalindrome("8V8K;G;K;V;"));
        System.out.println(isPalindrome("0PP0"));
        System.out.println(isPalindrome("0P"));
    }
}
