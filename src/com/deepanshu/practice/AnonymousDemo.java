package com.deepanshu.practice;
interface Age {
    int x = 21;
    void getAge();
}
public class AnonymousDemo {
    public static void main(String[] args) {
//        Anonymous Inner Class
//        object of inteface doesn't can't be created in Java
        Age obj = new Age() {
            @Override
            public void getAge() {
                System.out.println(x);
            }
        };
        obj.getAge();
    }
}
