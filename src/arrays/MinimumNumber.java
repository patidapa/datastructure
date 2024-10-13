package arrays;

public class MinimumNumber {
    public static void main(String args[]) {
        int arr[] = {5, 9, 8, 4, 3, 0, 2};
        int min=arr[0];
        for(int i=1;i<arr.length;i++){
            if(arr[i]<min){
                min=arr[i];
            }
        }
        System.out.print("Minimum element is "+min );
    }

}
