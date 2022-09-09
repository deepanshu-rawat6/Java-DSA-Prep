package com.deepanshu;
import java.util.*;
public class tryandtest {
    public static void main(String[] args) {

    }

    static int prime(int x) {
        int i = 2;
        while (i * i <= x) {
            if (x % i == 0) {
                return 0;
            }
            i++;
        }

        return 1;
    }
}
