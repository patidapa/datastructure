package recursion;

public class Fibonacicc {
    public static void main(String args[]){
        int a=0;
        int b=1;
        int c=a+b;
        System.out.print("Fibonacicc of given num: "+a+ ","+b+", ");
        fibonacic(a,b,c,5);

    }

    private static void fibonacic(int a,int b,int c,int num) {
        if(num==0){
            return;
        }
        System.out.print(c+", ");
        a=b;
        b=c;
        fibonacic(a,b,a+b,num-1);
    }
}
