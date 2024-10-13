package arrays;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int arr[] = {0, 2, 6, 10, 11, 7};
        int target=9;
        int result[]=new int[2];
        Map map=new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(!map.containsKey(target-arr[i])){
               map.put(arr[i],i);
            }else{
                result[1]=i;
                result[0]= (int) map.get(target-arr[i]);
            }
        }
        System.out.print(map);
        System.out.print("Maximum sub array sum is "+result[0] +", "+result[1] );
    }
}
