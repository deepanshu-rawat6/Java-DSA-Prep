import java.util.Scanner;

public class NewtonSQRT {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        System.out.printf("%.3f",sqrt(n));
    }
    static double sqrt(double n){ 
        double x=n;
        double root;
        while(true){
            root=0.5*(x+(n/x));
            if(Math.abs(root-x)<0.05) break;
            x=root;
        }
        return root;
    }
}
