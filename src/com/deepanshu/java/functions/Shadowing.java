package com.deepanshu.java.functions;

public class Shadowing {
    static int a = 100;
    public static void main(String[] args) {
        System.out.println(a);

        int a = 50;
        System.out.println(a); // Prints 50 -> because of shadowing concept, the var outside current scope is shadowed by var in the current scope
        func();
    }

    public static void func() {
        System.out.println(a);
    }
}
