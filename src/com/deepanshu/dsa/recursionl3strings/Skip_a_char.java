package com.deepanshu.dsa.recursionl3strings;

public class Skip_a_char {
    public static void main(String[] args) {
//        cal("","baccad");
        System.out.println(cal_return("baccad"));
        System.out.println(cal_string("baccappled"));
        System.out.println(cal_skip_app("baccappld"));
    }

//    Skips given character from the unprocessed string
    static void cal(String p,String up){
        if(up.isEmpty()){
            System.out.println(p);
            return;
        }
        char ch=up.charAt(0);
        if(ch=='a'){
            cal(p,up.substring(1));
        }else{
            cal(p+ch,up.substring(1));
        }
    }

    static String cal_return(String up){
        if(up.isEmpty()){
            return "";
        }
        char ch=up.charAt(0);
        if(ch=='a'){
            return cal_return(up.substring(1));
        }else{
            return ch+cal_return(up.substring(1));
        }
    }

//    Skips string from the given unprocessed string
    static String cal_string(String up){
        if(up.isEmpty()){
            return "";
        }
        if(up.startsWith("apple")){
            return cal_string(up.substring(5));
        }else{
            return up.charAt(0)+cal_string(up.substring(1));
        }
    }

//    Skips app if the combination is not an apple if not then adds apple
    static String cal_skip_app(String up){
        if(up.isEmpty()){
            return "";
        }
        if(up.startsWith("app") && !up.startsWith("apple")){
            return cal_skip_app(up.substring(3));
        }else{
            return up.charAt(0)+cal_skip_app(up.substring(1));
        }
    }
}
