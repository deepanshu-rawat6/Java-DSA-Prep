package com.deepanshu.dsa_practice.gfg;

import java.io.FilterOutputStream;

public class FirstUpperCaseLetter {
    public static void main(String[] args) {
        String str = "GeeksForGeeks";
        System.out.println(firstUpperCaseLetter(str, 0));
    }

    public static char firstUpperCaseLetter(String str, int idx) {
        if (str.charAt(idx) == '\0') {
            return 0;
        }
        if (Character.isUpperCase(str.charAt(idx))) {
            return str.charAt(idx);
        }
        return firstUpperCaseLetter(str, idx + 1);
    }
}
