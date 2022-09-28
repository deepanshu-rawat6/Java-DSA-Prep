package com.deepanshu.oops.inheritance;

public class Box {
    double l;
    double h;
    double w;

//    Default constructor
    Box(){
        this.l=-1;
        this.h=-1;
        this.w=-1;
    }

//    Cube
    Box(double side){
        this.l=side;
        this.h=side;
        this.w=side;
    }

//    Cuboid
    Box(double l,double w,double h){
        this.l=l;
        this.w=w;
        this.h=h;
    }

    Box(Box old){
        this.l=old.l;
        this.w=old.w;
        this.h=old.h;
    }

    public void display_info(){
        System.out.println("Running the box");
    }

}
