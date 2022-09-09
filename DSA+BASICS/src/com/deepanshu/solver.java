package com.deepanshu;
import java.util.Scanner;
public class solver {
    public static void main(String args[]){
        int t;
        Scanner sc=new Scanner(System.in);
        t=sc.nextInt();
        if(t>1000||t<1){
            System.exit(0);
        }
        for (int i=1; i<=t ; i++ ) {
            compute();
        }
    }
    static void compute() {
        int n, m = 0,x=0;
        int sum = 0;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        if (n > 100 || n < 1) {
            System.exit(0);
        }
        int num[] = new int[n];
        int ans[]=new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = sc.nextInt();
            if (num[i] < 1 || num[i] > (int) Math.pow(2, 20)) {
                System.exit(0);
            }
            sum = sum + num[i];
        }
        if (isPowerOfTwo(sum)) {
            System.out.println(m);
            System.exit(0);
        }else {
            int i = 0;
            for (x = 2; x <= (int) Math.pow(2, 30); x++) {
                for (i = 0; i < n; i++) {
                    num[i] *= x;
                    sum = summ(num, n);
                    ans[i] = i + 1;
                    if (isPowerOfTwo(sum)) {
                        break;
                    }
                }

                m++;
                if(isPowerOfTwo(sum)){
                    break;
                }
            }
            System.out.println(m);
            System.out.println((i + 1) + "  " +x);
            for (int j=1;j<=i+1;j++){
                System.out.print(j+"   ");
            }
        }
    }
    static int summ(int [] num,int n){
        int sum=0;
        for (int i=0;i<n;i++){
            sum+=num[i];
        }
        return sum;
    }
    static boolean isPowerOfTwo (int x)
    {
     /* First x in the below expression is
     for the case when x is 0 */
        return x!=0 && ((x&(x-1)) == 0);
    }
}
