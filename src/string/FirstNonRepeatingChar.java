package string;

import java.util.HashMap;
import java.util.Map;

public class FirstNonRepeatingChar {
    public static void main(String[] args) {
        String str = "racecars";
       Map<Character,Integer> map=new HashMap<>();
       char[]ch=str.toCharArray();
       for(char c:ch){ 
           if(map.containsKey(c)){
               map.put(c,map.get(c)+1);
           }else{
               map.put(c,1);
           }
       }
       for(int i=0;i<ch.length;i++){
           if(map.get(ch[i])==1){
               System.out.print("First non repeating char is "+ch[i]);
               break;
           }
       }

    }
}
