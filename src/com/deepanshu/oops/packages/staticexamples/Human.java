package com.deepanshu.oops.packages.staticexamples;

public class Human {
    int age;
    String name;
    boolean married;
    int salary;
//    static var are apart from instance vars
//    static vars can still be used even if we don't create objects
    static int population;

    static void message(){
        System.out.println("Hello!");
//        System.out.println(this.age);   // can't use "this" over here
    }
    public Human(int age, String name, boolean married, int salary) {
        this.age = age;
        this.name = name;
        this.married = married;
        this.salary = salary;
//      We can also use <object name>.<static var> but since it is not related
//      objects directly so we can use <class name>.<static var>
        Human.population+=1; // this.population+=1;

        Human.message();
    }
}
