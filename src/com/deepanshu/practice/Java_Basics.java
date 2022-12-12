package com.deepanshu.practice;

import java.util.Scanner;

class MyException extends Exception {
    MyException(){
        System.out.println("Kindly enter the valid marks obtained by the Student!");
    }
}
public class Java_Basics {
    public int[] test() throws MyException {
        Scanner sc = new Scanner(System.in);
        int[] marks = new int[10];
        try{
            for (int i = 0; i < 10; i++) {
                int x = sc.nextInt();
                if (x > 100 || x < 0) {
                    throw new MyException();
                }
                marks[i] = x;
            }
            display(marks);
        } catch (Exception e){
            System.out.println("Exception Caught!");
            System.out.println("Kindly run the program again and enter valid entries");
        }finally {
            System.out.println("Adios!");
        }
        return marks;
    }
    public void display(int[] marks) throws MyException {
        for(int entry: marks) {
            System.out.println(entry);
        }
    }
    public static void main(String[] args) throws MyException {
        Java_Basics obj = new Java_Basics();
        obj.test();
    }
}