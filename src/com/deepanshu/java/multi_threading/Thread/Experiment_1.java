package com.deepanshu.java.multi_threading.Thread;
class Hi extends Thread{
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Hi");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
class Hello extends Thread{
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println("Hello");
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
public class Experiment_1 {
    public static void main(String[] args) throws InterruptedException {
        Hi ob1 = new Hi();
        Hello ob2 = new Hello();

        ob1.start();
        try{
            Thread.sleep(100);
        } catch (InterruptedException e){
            throw new RuntimeException(e);
        }
        ob2.start();

    }
}
