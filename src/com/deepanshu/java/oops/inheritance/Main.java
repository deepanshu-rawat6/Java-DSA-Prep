package com.deepanshu.java.oops.inheritance;

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

//        System.out.println(box.l+" "+box.w+" "+box.h);
//
//        Box box1=new Box(box);
//
//        System.out.println(box1.l+" "+box1.w+" "+box1.h);

        BoxWeight box3=new BoxWeight();

        BoxWeight box4=new BoxWeight(2,3,4,5);

        System.out.println(box3.h+" "+box3.weight);

        Box box5=new BoxWeight(2,3,4,5);
//        only the type of the reference var can decide which members will be accessed not the object
        System.out.println(box5.w);


//        there are many vars in both parent and child class
//        you are given access to vars that are in the ref type i.e. BoxWeight
//        hence, you should have access to weight vars
//        this also means, that the ones you are trying to access should be initialized
//        but here, when the obj itself is of type parent class, how will you call the constructor of child class
//        this is why error
//        BoxWeight box6=new Box(1,2,3,4);
//        System.out.println(box6.weight);

        BoxPrice obj=new BoxPrice(5,8,1);

        Box.greetings();

        Box box1=new BoxWeight();
        BoxWeight.greetings(); // you can inherit but you cannot override


    }
}
