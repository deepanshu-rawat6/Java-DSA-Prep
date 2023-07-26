package com.deepanshu.java.oops.packages.a;

// This statement has the location of the function to be invoked
// import static <package path>.<Class name>.<Function to be invoked>
import static com.deepanshu.java.oops.packages.a.Message.display;
import static com.deepanshu.java.oops.packages.a.Message.display;

public class Greetings {
    public static void main(String[] args) {
        System.out.println("Hello there! This class is from package a");
        display();
    }
}
