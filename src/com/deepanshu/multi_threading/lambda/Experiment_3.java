package com.deepanshu.multi_threading.lambda;

public class Experiment_3 {
    public static void main(String[] args) throws Exception {
//        using anonymous class and lambda expressions
        Thread t1 = new Thread(() ->
        {
            for (int i = 0; i < 5; i++) {
                System.out.println("Hi" + " , "+ Thread.currentThread().getPriority() + " , " + Thread.currentThread().getName());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        },"Hi Thread");
        Thread t2 = new Thread(() ->
        {
            for (int i = 0; i < 5; i++) {
                System.out.println("Hello" + " , "+ Thread.currentThread().getPriority() + " , " + Thread.currentThread().getName());
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        },"Hello Thread");


//        t1.setName("Hi Thread");
//        t2.setName("Hello Thread\n");

        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY);

        System.out.println(t1.getPriority());
        System.out.println(t2.getPriority());

        System.out.println(t1.getName());
        System.out.println(t2.getName());

        t1.start();
        try{
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        t2.start();

//        This let the main thread to wait for its execution and let only t1 and t2 execute
        t1.join();
        t2.join();

//        isAlive() method helps in identifying whether the thread is alive or not.
//        it returns a boolean value
        System.out.println("\n" + t1.isAlive());

        System.out.println("\nBYE");
    }
}