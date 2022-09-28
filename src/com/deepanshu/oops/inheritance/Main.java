package com.deepanshu.oops.inheritance;

public class Main {
    public static void main(String[] args) {
//        calls out the default constructor
//        Box box=new Box();
        /*
        Output:
             -1.0 -1.0 -1.0
         */

//        calls out the constructor with single argument
//        Box box=new Box(5.0);
        /*
        Output:
           5.0 5.0 5.0
         */

//        calls out the constructor with 3 arguments
        Box box=new Box(4,5,6);
        /*
        Output:
            4.0 5.0 6.0
         */

        System.out.println(box.l+" "+box.w+" "+box.h);

        Box box1=new Box(box);

        System.out.println(box1.l+" "+box1.w+" "+box1.h);
    }
}
