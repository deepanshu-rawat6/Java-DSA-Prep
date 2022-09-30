package com.deepanshu.oops.singleton;

//Singleton class means only one object can be created
public class Singleton {
    private Singleton(){

    }
    private static Singleton instance;

    public static Singleton getInstance(){
//        check whether 1 obj only is created or not
        if(instance==null){
            instance=new Singleton();
        }

        return instance;
    }
}
