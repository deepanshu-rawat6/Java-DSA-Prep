package com.deepanshu.practice;

public class ExceptionHandling {
    public void helper(){
        int a = 3;
        int b = 0;
        try {
            System.out.println(a/b);
        }
        catch (ArithmeticException e) {
            System.out.println(e);
//            e.printStackTrace();
            System.out.println(e.toString());
            System.out.println(e.getMessage());
        }
    }
    public static void main(String[] args) {
        ExceptionHandling obj = new ExceptionHandling();
        obj.helper();
    }
}
