package arrays;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum2 {
    public static void main(String[] args) {
        int arr[] = {0, 2, 6, 10, 11, 7};
        Arrays.sort(arr);
        int result[]=new int[2];
        int target=9;
        int left=0;
        int right=arr.length-1;
        while(left<right){
            int sum=arr[left]+arr[right];
            if(sum==target){
                result[0]=arr[left];
                result[1]=arr[right];
                break;
            }else if (sum<target){
                left++;
            }else{
                right--;
            }
        }
        System.out.print("Maximum sub array sum is "+result[0] +", "+result[1] );
    }
}
