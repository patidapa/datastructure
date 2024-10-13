package recursion;

public class RemoveDuplicate {
    public static boolean[] map=new boolean[26];
    public static void main(String args[]) {
        removeDuplicate("abccdab",0,"");
    }

    private static void removeDuplicate(String str, int idx, String newS) {
        if(idx==str.length()){
            System.out.println(newS);
            return;
        }
        char curr=str.charAt(idx);
        if(map[curr-'a']){
            removeDuplicate(str,idx+1,newS);
        }else{
            newS+=curr;
            map[curr-'a']=true;
            removeDuplicate(str,idx+1,newS);
        }
    }
}
