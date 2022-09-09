public class concept {
    public static void main(String[] args) {
        Print_before(5);
        Print_after(5);
    }

//    Infinite Recursion because n-- is passing n then will subtract after the function is removed from stack
    private static void Print_after(int n) {
        if(n==0) return;
        System.out.println(n);
        Print_after(n--);
    }
    private static void Print_before(int n) {
        if(n==0) return;
        System.out.println(n);
        Print_before(--n);
    }
}
