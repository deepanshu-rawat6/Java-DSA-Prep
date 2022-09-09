public class recursion {
    public static void main(String[] args) {
        System.out.println(func(36));
    }
    static long func(long n){
        if(n==0) return 0;
        if(n==1) return 5;
        return 3*func(n-1)+4*func(n-2);
    }
}
