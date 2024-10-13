package recursion;

public class SortedArray {
    public static void main(String args[]) {
        int[] arr={1,2,3,4,5};

        System.out.println("Arrays is sorted "+isSorted(arr,0) );
    }

    private static boolean isSorted(int[] arr, int idx) {
        if(idx==arr.length-1){
            return true;
        }
        if(arr[idx]>=arr[idx+1]){
            return false;
        }
       return isSorted(arr,idx+1);
    }
}
