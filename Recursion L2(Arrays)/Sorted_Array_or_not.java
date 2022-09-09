public class Sorted_Array_or_not {
    public static void main(String[] args) {
        int[] arr={1,2,4,3,5};
        System.out.println(sorted(arr,0));
    }
    static boolean sorted(int[] arr,int x){
//        Base Condition
        if(x==arr.length-1) return true;
        return arr[x]<arr[x+1] && sorted(arr,x+1);
    }
}
