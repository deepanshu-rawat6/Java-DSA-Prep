package com.deepanshu.oops.packages.staticexamples;

public class StaticBlock {
    static int a=4;
    static int b;

    /*
    * Will only run once, when the first obj is created i.e.
    * when the class is loaded for the first time
    */
    static {
        System.out.println("I'm inside static block");
        b=a*5;
    }

    public static void main(String[] args) {
        StaticBlock obj=new StaticBlock();
        System.out.println(StaticBlock.a+" "+StaticBlock.b);

        StaticBlock.b+=3;
        System.out.println(StaticBlock.a+" "+StaticBlock.b);

        StaticBlock obj2=new StaticBlock();
        System.out.println(StaticBlock.a+" "+StaticBlock.b);
    }
}
