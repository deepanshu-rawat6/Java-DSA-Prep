import java.util.Scanner;

public class Count_zero_in_Num {
    static int var=0;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.println(calculate(n));
    }
    public static int calculate(int n){
        return helper(n,0);
    }
//    special pattern, how to pass a value to above function calls
    public static int helper(int n,int c){
        if(n==0) return c;
        int rem=n%10;
        if(rem==0) return helper(n/10,c+1);
        else return helper(n/10,c);
    }
}
