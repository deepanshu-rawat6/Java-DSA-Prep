import java.util.*;
public class string_basics {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
//        for(int i=0;i<str.length();i++){
//            System.out.println(str.charAt(i));
//        }
        if(str1.compareTo(str2)==0) System.out.println("Strings are equal!");
        else System.out.println("Strings are unequal!");
    }
}
