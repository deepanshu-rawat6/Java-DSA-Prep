package com.deepanshu.java.functions;

public class Swapping {
    public static void swap(int num1,int num2) {
        int temp = num1;
        num1 = num2;
        num2 = temp;

        /*
             num1 = num1 + num2;
             num2 = num1 - num2;
             num1 = num1 - num2;
         */
    }
    public static void swapInteger(Integer num1,Integer num2) {
        int temp = num1;
        num1 = num2;
        num2 = temp;

//        num1 = num1 + num2;
//        num2 = num1 - num2;
//        num1 = num1 - num2;
    }
    public static void main(String[] args) {
//        int a = 10;
//        int b = 20;
//        System.out.println(a + " and " + b);
//        swap(a,b); // Here, in the case of functions and primitives, only call by value happens
//        System.out.println(a + " and " + b);

        Integer a1 = 10;
        Integer b1 = 20;
        System.out.println(a1 + " and " + b1);
        swapInteger(a1,b1);
        System.out.println(a1 + " and " + b1);
    }
}
