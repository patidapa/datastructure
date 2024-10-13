package arrays;

public class SeconMax {

    public static void main(String args[]) {
        int arr[] = {5, 9, 8, 4, 3, 0, 2};
       int firstMax= Integer.MIN_VALUE;
       int secondMax= Integer.MIN_VALUE ;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>firstMax){
                secondMax=firstMax;
                firstMax=arr[i];
            } else if (arr[i]>secondMax && firstMax!=secondMax) {
                secondMax=arr[i];
            }
        }
        System.out.print("Minimum element is "+secondMax );
}
}
