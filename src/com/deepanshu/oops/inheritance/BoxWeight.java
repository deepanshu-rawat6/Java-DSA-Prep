package com.deepanshu.oops.inheritance;

public class BoxWeight extends Box {
     double weight;

//    //    @Override // can't override static methods
//    static void greetings(){
//        System.out.println("Hello, I'm inside BoxWeight Class. Greetings!");
//    }

     public BoxWeight() {
           this.weight=-1;
     }

     BoxWeight(BoxWeight other){
         super(other);
         weight=other.weight;
     }

     BoxWeight(double side,double weight){
         super(side);
         this.weight=weight;
     }

    public BoxWeight(double l, double w, double h, double weight) {
        super(l, w, h);  //what's this? call the parent class constructor
//        used to initialise values present in the parent class


//        In case, if we want to access specific vars from parent class then we have to use "super.<var>"
//        System.out.println(super.weight);

        this.weight = weight;
    }
}
