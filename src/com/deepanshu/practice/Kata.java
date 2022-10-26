package com.deepanshu.practice;

public class Kata {
    public static void main(String[] args) {
        System.out.println(getMiddle("test"));
        System.out.println(getMiddle("testing"));
        System.out.println(getMiddle("A"));
    }
    public static String getMiddle(String word) {
        //Code goes here!
        int len = word.length();
        StringBuilder str = new StringBuilder();
        int i = 0, j = len, diff = 0;
        if ((len & 1) == 0){
            while (i < j){
                diff = j - i;
                if (diff == 2){
                    str.append(word.charAt(i));
                    str.append(word.charAt(j -1));
                }
                i++;
                j--;
            }
        }else{
            while (i < j){
                diff = j - i;
                if (diff == 1){
                    if ( len == 1){
                        str.append(word.charAt(0));
                        break;
                    }
                    str.append(word.charAt(i));
                }
                i++;
                j--;
            }
        }
        return str.toString();
    }
}
