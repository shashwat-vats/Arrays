package Easy;

import java.util.Arrays;

public class E2_2ndLargestInArray {
    public static void main(String[] args) {

        int[] arr = {2,5,3,7,2,5,7,4,3,1,3,5,6,342,345,53,32,44,12};
        int n = arr.length;
        int largest = arr[0];
        int sLarge = -1;
         for(int i=1; i<n; i++) {
             if(arr[i]>largest) {
                 sLarge = largest;
                 largest = arr[i];
             }
             else if(arr[i] < largest && arr[i]>sLarge) {
                 sLarge = arr[i];
             }
         }
         System.out.println("Second Largest: "+ sLarge);
    }
}
