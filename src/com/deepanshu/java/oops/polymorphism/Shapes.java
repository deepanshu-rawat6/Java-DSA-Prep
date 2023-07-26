package com.deepanshu.java.oops.polymorphism;

public class Shapes {
//    cannot override "final" methods

//    example of early binding because many steps after compiling are skipped since
//    our method is declared as final

//    whereas, the override methods are examples of late or dyna mic binding
    void area(){
        System.out.println("I'm in shapes");
    }
}
