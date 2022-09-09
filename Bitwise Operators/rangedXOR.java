import java.util.Scanner;

public class rangedXOR {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();

        // BEST approach O(1) time
        int ans=XOR(b)^XOR(a-1);


        // Worst approach O(N) can give TLE if ranges are above 10^7-10^8
        // for(int i=a;i<=b;i++){
        //     ans^=i;
        // }
        System.out.println(ans);
    }
    static int XOR(int x){
        if(x%4==0) return x;
        else if(x%4==1) return 1;
        else if(x%4==2) return x+1;
        else return 0;
    }
}
