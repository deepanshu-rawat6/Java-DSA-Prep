package com.deepanshu.oops.packages.staticexamples;

public class Main {
    /*
    * Why main is static??
    * -> Since main is the first thing in a class that is executed
    *  and for running methods we need to create objects of the class, so we
    *  declare main to be "static".
     */
    public static void main(String[] args) {
        Human obj=new Human(20,"object",false,100000);
        Human deepanshu =new Human(19,"deepanshu",false,200000);
        Human xyz=new Human(1,"",true,1);

        /*
        * Instead of using <object name>.<static var> we can use <class name>.<static var>
        */
        System.out.println(Human.population);   // We can also use <object name>.<static var> but since it is not related
        System.out.println(Human.population);   // objects directly so we can use <class name>.<static var>

//        Adding 3rd object
        System.out.println(Human.population);

        /*
        * The convention of using static var is to access them using:
        *           <class name>.<var>
        *  Even if we access vars by object name, but it is a good practice
        *  to use class name instead of object name
         */


//        Inside static methods we cannot use non-static members,so
//        we need to either create object of the class or declare function to be static
//        greetings();
        fun();
    }


//    Anything which is non-static belongs to an object
//    void greetings(){
//        System.out.println("Hello");
//    }

    static void fun(){
//        Since a non-static content cannot be used inside a static content
//        We need to reference it using an object or reference var
        Main obj=new Main();
        obj.greetings();
    }

     void greetings(){
        System.out.println("Hello!");
    }
}
