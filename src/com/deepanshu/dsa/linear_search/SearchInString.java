package com.deepanshu.dsa.linear_search;

import java.util.Arrays;

public class SearchInString {
    public static boolean search(String name, char target) {
        if (name.isEmpty()) {
            return false;
        }
        for (char i: name.toCharArray()) {
            if (i == target) {
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        String name = "Deepanshu";
        char target = 'e';
        System.out.println("Displaying the string: " + Arrays.toString(name.toCharArray()));
        System.out.println("Searching for the character: " + target);
        System.out.println(search(name, target));
    }
}
