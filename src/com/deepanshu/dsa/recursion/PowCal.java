package com.deepanshu.dsa.recursion;

public class PowCal {
    public static void main(String[] args) {
//        System.out.println(myPow(2,10));
        System.out.println(power(3,10));
    }
    public static double myPow(double x, int y) {
        double temp;
        if (y == 0)
            return 1;
        temp = myPow(x, y / 2);
        if (y % 2 == 0)
            return temp * temp;
        else {
            if (y > 0)
                return x * temp * temp;
            else
                return (temp * temp) / x;
        }
    }
    static int power(int x, int n)
    {
        int result = 1;
        while (n > 0) {
            if (n % 2 != 0) // y is odd
            {
                result = result * x;
            }
            x = x * x;
            n = n >> 1; // y=y/2;
        }
        return result;
    }
}
