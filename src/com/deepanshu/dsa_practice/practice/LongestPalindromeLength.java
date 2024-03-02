package com.deepanshu.dsa_practice.practice;

public class LongestPalindromeLength {
    public static boolean isPalindrome(String word) {
//        return word.contentEquals(new StringBuilder(word).reverse());


//        Checking for Palindrome logic
        int i = 0, j = word.length() - 1;
        while (i < j) {
            char ch1 = word.charAt(i);
            char ch2 = word.charAt(j);

            if (Character.compare(ch1, ch2) != 0) {
                return false;
            }

            i++;
            j--;

        }

        return true;
    }

    public static int maxPalindromeLength(String s, int n) {
        int maxLength = -1;

        // Split the string into words
        String[] words = s.split(" ");

        for (String word : words) {
            // Check if the word is a palindrome and its length is greater than the current maxLength
            if (isPalindrome(word) && word.length() > maxLength) {
                maxLength = word.length();
            }
        }

        return maxLength;
    }

    public static void main(String[] args) {
        int n = 10;  // replace with the actual size of the string
        String s = "a bb dede ded racecar";

        int result = maxPalindromeLength(s, n);

        if (result != -1) {
            System.out.println("The length of the longest palindrome word is: " + result);
        } else {
            System.out.println("No palindrome word found.");
        }
    }
}
