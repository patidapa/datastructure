package arrays;

public class MissingNumber {
    public static void main(String[] args) {
        int arr[] = {2, 8, 1, 5, 6, 3, 7};
        int n=arr.length+1;
        int sum=(n* (n+1))/2;
        int total=0;
        for(int i=0;i<arr.length;i++){
            total=total+arr[i];
        }
        int mN=sum-total;
        System.out.print("missing number is "+mN);
    }
}
