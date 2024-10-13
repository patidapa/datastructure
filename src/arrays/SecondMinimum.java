package arrays;

public class SecondMinimum {
    public static void main(String args[]) {
        int arr[] = {5, 9, 8, 4, 3, 0, 2};
        int fmin=Integer.MAX_VALUE;
        int smin=Integer.MAX_VALUE;
        for(int i=0;i<arr.length;i++){
            if(arr[i]<fmin){
                smin=fmin;
                fmin=arr[i];
            }else if(arr[i]<smin && fmin !=smin){
                smin=arr[i];
            }
        }
        System.out.print("Second Minimum element is "+smin );
        }

    }

