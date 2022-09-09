import java.util.Scanner;

public class power_of_2_or_not {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        boolean ans= (n & (n - 1)) == 0;
        if(n==0) ans=false;
        System.out.println(ans);
    }
}
