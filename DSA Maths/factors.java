import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class factors {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        // fact(n);
        // factorder(n);
        ArrayList<Integer> ans=factors_in_order(n);
        ans.forEach((x) -> System.out.print(x+" "));
    }
    static void fact(int n){
        for(int i=1;i*i<=n;i++){
            if(n%i==0){
                if(n/i==i) System.out.println(i);
                else System.out.println(i+" "+n/i);
            }
        }
    }
    static void factorder(int n){
        ArrayList<Integer> ans=new ArrayList<>();
        for(int i=1;i*i<=n;i++){
            if(n%i==0){
                if(n/i==i) System.out.print(i+" ");
                else {
                    System.out.print(i+" ");
                    ans.add(n/i);
                }
            }
        }
        for(int i=ans.size()-1;i>=0;i--){
            System.out.print(ans.get(i)+" ");
        }
    }
    // This function calculates the divisors by O(N^(1/2)) approach and also maintains the ascending order
    static ArrayList<Integer> factors_in_order(int n){
        ArrayList<Integer> ans=new ArrayList<>();
        int i;
        for (i = 1; i * i < n; i++) {
            if (n % i == 0)
                ans.add(i);
        }
        if (i - (n / i) == 1) {
            i--;
        }
        for (; i >= 1; i--) {
            if (n % i == 0)
                ans.add(n/i);
        }
        return ans; // returns the second largest element in the vector
        
    }
}


