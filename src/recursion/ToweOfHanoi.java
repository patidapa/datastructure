package recursion;

public class ToweOfHanoi {
    public static void main(String args[]){
        towerHanoi(3,"S","H","D");

    }

    private static void towerHanoi(int num, String s, String h, String d) {
        if(num==1){
            System.out.println("transfer disk "+num+" from "+s+" to "+d );
            return;
        }
        towerHanoi(num-1,s,d,h);
        System.out.println("transfer disk "+num+" from "+s+" to "+d );
        towerHanoi(num-1,h,s,d);

    }
}
