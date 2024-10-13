package recursion;

public class SubSequence {
    public static void main(String args[]) {
        subSequence("abc",0,"");
    }

    private static void subSequence(String str, int idx, String newS) {
        if(idx==str.length()){
            System.out.println(newS);
            return;
        }
        char curr=str.charAt(idx);
        subSequence(str,idx+1,newS+curr);
        subSequence(str,idx+1,newS);
    }
}
