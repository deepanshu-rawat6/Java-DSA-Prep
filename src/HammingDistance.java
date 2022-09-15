import java.util.Scanner;

public class HammingDistance {
    public static int hammingDistance(int x, int y) {
        int ans=x^y;
        int c=0;
        while(ans>0){
            c++;
            ans&=(ans-1);
        }
        return c;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int x=sc.nextInt();
        int y=sc.nextInt();
        System.out.println(hammingDistance(x,y));
    }
}
