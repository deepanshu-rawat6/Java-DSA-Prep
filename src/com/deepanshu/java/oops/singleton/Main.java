package com.deepanshu.java.oops.singleton;

import com.deepanshu.java.oops.access.A;

public class Main {
    public static void main(String[] args) {

        Singleton obj1=Singleton.getInstance();

        Singleton obj2=Singleton.getInstance();

        Singleton obj3=Singleton.getInstance();

//        all 3  reference vars are pointing to just one object


        A a=new A(10,"Deepanshu");
        a.getNum();
    }
}
