package arrays;

public class MaximumSum {
    public static void main(String[] args) {
        int arr[] = {4, 3, -2, 6, -12, 7, -1, 6};
        int maxSofar=arr[0];
        int currentMax=arr[0];
        for(int i=1;i<arr.length;i++){
            currentMax=currentMax+arr[i];
            if(currentMax<arr[i]){
                currentMax=arr[i];
            }
            if(maxSofar<currentMax){
                maxSofar=currentMax;
            }
        }
        System.out.print("Maximum sub array sum is "+maxSofar);
    }
}
