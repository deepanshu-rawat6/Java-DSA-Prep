package com.deepanshu.java.functions;

public class MethodOverloading {
    public static void main(String[] args) {
        func(10);
        func("Deepanshu");
    }

    public static void func(int num){
        System.out.println(num);
    }

    public static void func(String str) {
        System.out.println(str);
    }
}
