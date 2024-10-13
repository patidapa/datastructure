package string;

import java.util.HashMap;
import java.util.Map;

public class Palindrom {
    public static void main(String[] args) {
        String str = "madamr";
        char ch[]=str.toCharArray();
        int start=0;
        int end=str.length()-1;
        boolean isPlaindrom=true;
        while (start<end){
            if(ch[start]!=ch[end]){
                isPlaindrom=false;
                break;
            }
            start++;
            end--;
        }
        if(isPlaindrom){
                System.out.print("String is Palindrom");
        }else{
            System.out.print("String is not Palindrom");
        }
    }
}
