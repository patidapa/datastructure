package recursion;

public class MoveAllZeros {
    static int count=0;
    public static void main(String args[]) {
        int[] arr={1,2,3,4,5};
        moveAllX("axbxxcdxx",0, new String(""));
}

    private static void moveAllX(String str,int idx,String newS) {
        if(idx==str.length()-1){
          for(int i=0;i<count;i++){
              newS+="x";
          }
          System.out.println(newS);
          return;
        }
        char curr=str.charAt(idx);
        if(curr=='x'){
            count++;
            moveAllX(str,idx+1,newS);
        }else{
            newS+=curr;
            moveAllX(str,idx+1,newS);
        }
    }
    }
