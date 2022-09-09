public class Pattern_1 {
    public static void main(String[] args) {
        Pattern_1 obj=new Pattern_1();
        obj.printing(5,0);
        obj.printing2(5,0);
    }
    void printing2(int r,int c){
        if(r==0){
            return;
        }
        if(c<r){
            printing2(r,c+1);
            System.out.print("* ");
        }else{
            printing2(r-1,0);
            System.out.println();
        }
    }
    void printing(int r,int c){
        if(r==0){
            return;
        }
        if(c<r){
            System.out.print("* ");
            printing(r,c+1);
        }else{
            System.out.println();
            printing(r-1,0);
        }
    }
}
