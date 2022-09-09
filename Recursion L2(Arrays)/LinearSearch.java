import java.util.ArrayList;

public class LinearSearch {
    public static void main(String[] args) {
        int[] arr={1,23,10,43,43,43,80,69};
        int var=43;
//        System.out.println(search(arr,var,0));
//        System.out.println(searchIndex(arr,var,0));
//        searchAllIndex(arr,var,0);
//        System.out.println(list);
        ArrayList<Integer> list1=new ArrayList<Integer>();
        ArrayList<Integer> ans=searchallIndex(arr,var,0,list1);
//      System.out.println(searchallIndex(arr,var,0,ans));
        System.out.println(ans);
        System.out.println(list1);


//        Not optimised
        System.out.println(searchallIndex2(arr,var,0));
    }

    private static boolean search(int[] arr, int target,int index) {
//        Base Condition
        if(index== arr.length) return false;
        return arr[index]==target || search(arr,target,index+1);
    }
    static int searchIndex(int[] arr,int target,int index){
//        Base Condition
        if(index==arr.length) return -1;
        if(arr[index]==target){
            return index;
        }else{
            return searchIndex(arr,target,index+1);
        }
    }

//    Searching multiple occurrences of a number and adding them into an arraylist
    static ArrayList<Integer> list=new ArrayList<Integer>();
    static void searchAllIndex(int[] arr,int target,int index){
//        Base Condition
        if(index==arr.length) return;
        if(arr[index]==target){
            list.add(index);
        }
        searchAllIndex(arr,target,index+1);
    }


//    Returning arraylist (Searching multiple occurrences of a number and adding them into an arraylist)
//    ArrayList<Integer> ans has reference var to points to the same value
    static ArrayList<Integer> searchallIndex(int[] arr,int target,int index,ArrayList<Integer> ans){
         if(index==arr.length) return ans;
        if(arr[index]==target){
            ans.add(index);
        }
        return searchallIndex(arr,target,index+1,ans);
    }

//    Important concept of not having the ArrayList in place of function arguments

//    Not an optimised approach but still useful in some cases
static ArrayList<Integer> searchallIndex2(int[] arr,int target,int index){
        ArrayList<Integer> list2=new ArrayList<Integer>();
        if(index==arr.length) return list2;

//    This will contain answer for that function call only
        if(arr[index]==target){
            list2.add(index);
        }
        ArrayList<Integer> ansFromBelowCall=searchallIndex2(arr,target,index+1);
        list2.addAll(ansFromBelowCall);
        return list2;
    }
}
