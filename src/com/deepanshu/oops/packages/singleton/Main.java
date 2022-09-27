package com.deepanshu.oops.packages.singleton;

public class Main {
    public static void main(String[] args) {

        Singleton obj1=Singleton.getInstance();

        Singleton obj2=Singleton.getInstance();

        Singleton obj3=Singleton.getInstance();

//        all 3  reference vars are pointing to just one object
    }
}
