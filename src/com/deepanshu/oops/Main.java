package com.deepanshu.oops;

public class Main {
    public static void main(String[] args) {

//        Student deepanshu;
//        deepanshu=new Student();

/*
        Here "new" keyword is used to dynamically allocate the memory,
        for the reference variable ("deepanshu")

 */

//        Here Student() is the constructor which is invoked here for initializing values
        Student deepanshu=new Student();

//        deepanshu.rno=11;
//        deepanshu.name="Deepanshu";
//        deepanshu.marks=95.0F;

        deepanshu.change_name("sehnsucht");
        deepanshu.greeting();

        System.out.println(deepanshu.rno);
        System.out.println(deepanshu.name);
        System.out.println(deepanshu.marks);
    }
}


// Creating for every single student
class Student{
    int rno;
    String name;
    float marks;


    void greeting(){
        System.out.println("Hello there! My name is "+this.name);
    }

    void change_name(String Newname){
        name=Newname;
    }

//    we need a way to add the values of the above
//    properties by object

//    we need one word to access every object
    Student(){
        this.rno=11;
        this.name="Deepanshu";
        this.marks= 95.0F;
    }
}
