package com.deepanshu.bitwiseoperators;

import java.util.Scanner;

public class nth_magic_number {
    static long[] pow5=new long[32];
    public static void main(String[] args){
        long ans=0;
        pow5[0]=5;
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int limit=(int)(Math.log(n)/Math.log(2))+1; //To get the number of digits
        for(int i=0;i<limit;i++){
            if(i!=0){
                pow5[i]=pow5[i-1]*5;
            }
            ans+=((n>>i)&1)*(pow5[i]);
        }
        System.out.println(ans);
    }
}
//Overall complexity of the code is O(log2(n))
