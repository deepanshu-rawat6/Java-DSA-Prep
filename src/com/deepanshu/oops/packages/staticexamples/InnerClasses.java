package com.deepanshu.oops.packages.staticexamples;

// Outside class cannot be static, because it is not itself dependent on any other class
public class InnerClasses {
//    hence Inner Classes can be static
    static class Test{
        String name;

        public Test(String name){
            this.name=name;
        }

        /*
         Skips JAVA to call the default toString() method instead calls the overridden toString() method
         */
        @Override
        public String toString(){
            return name;
        }
    }

//    class Test{
//        static String name;
//        public Test(String name){
//            Test.name=name;
//        }
//    }
//public static void main(String[] args) {
//    Test a=new Test("Deepanshu");
//    Test b=new Test("XYZ");
//
//    System.out.println(a.name);
//    System.out.println(b.name);
//
//        /*
//        Output:
//              XYZ
//              XYZ
//         */
//   Same static var was first changed to "Deepanshu" then it was changed to "XYZ"
//}

    public static void main(String[] args) {
        Test a=new Test("Deepanshu");
        Test b=new Test("XYZ");

        System.out.println(a.name);
        System.out.println(b.name);

        /*
        Output:
              Deepanshu
              XYZ
         */

//        Because Test is defined as static,
//        so it is not dependent on any instances of class InnerClasses


        System.out.println(a);
//        System is class, out is reference var of a class PrintStream and println is method
    }
}



//Static members and methods are resolved during compile time since they are independent of objects and stuff
