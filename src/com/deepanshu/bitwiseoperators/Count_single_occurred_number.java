package com.deepanshu.bitwiseoperators;

import java.util.Scanner;
public class Count_single_occurred_number {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int[] arr =new int[5];
        for (int i = 0; i < 5; i++) {
            arr[i]=sc.nextInt();
        }
        System.out.println(count_singly_occurred_number(arr));
    }
    public static int count_singly_occurred_number(int[] arr){
        int ans=arr[0];
        for (int i = 1; i < arr.length ; i++) {
            ans^=arr[i];
        }
        return ans;
    }
}
