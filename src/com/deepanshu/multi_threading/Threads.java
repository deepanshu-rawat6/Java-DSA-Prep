package com.deepanshu.multi_threading;

class MyThread extends Thread{
    int[] values = {6,5,1,7,8};
    public void run(){
        for(int i = 0; i < 5; i++) {
            values[i] = values[i] * 2;
        }
    }
}
public class Threads {
    public static void main(String[] args) {
        Thread t1 = new MyThread();
        t1.start();
    }
}
