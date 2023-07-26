package com.deepanshu.java.functions;

public class Scopes {
    public static void main(String[] args) {
        int x = 100;


        {
            x = 50;
            System.out.println(x); // Prints 50 (Blocked scope)


        }

        System.out.println(x);  // Prints 100 (default scope)


        /*
                Note:

                    We can assign any value to any var inside a scoped block, but we can't initialize again, and the updated value stays the same for the updated var, even outside the block

                    Also, if we initialize a var inside a block, then we can't use the var outside the block, but we can again initialize the same var outside the block
         */

    }


    /*
     Types of Scopes: Function Scope, Block Scope and Loop scope
     */

}
