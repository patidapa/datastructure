package recursion;

public class Factorial {
    public static void main(String args[]){
        int fact=factorial(5);
        System.out.print("Factorial of given num: "+fact);
    }

    private static int factorial(int num) {
        if(num==0 || num==1){
            return 1;
        }
        return num*factorial(num-1);
    }
}
