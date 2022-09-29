package com.deepanshu.oops.polymorphism;

public class Circle extends Shapes{
//    this will run when obj Circle is created
//    hence it is overriding the parent methods

    @Override //this is called annotation
    void area(){
        System.out.println("Area is pi*r*r");
    }
}
