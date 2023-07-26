package com.deepanshu.dsa_practice.practice;
class MyThread implements Runnable {

    @Override
    public void run() {

    }
}
public class ComplexNumbers{
    int real,imaginary;
    ComplexNumbers(int real,int imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }
    @Override
    public String toString(){
        return real + " + " + imaginary + "i";
    }
    public static void main(String[] args) {
        ComplexNumbers obj = new ComplexNumbers(2,3);
        System.out.println(obj);
    }
}
