package Easy;

public class E3_2ndSmallest {
    public static void main(String[] args) {

        int[] arr = {2,5,3,7,2,5,7,0,4,3,1,3,5,6,342,345,53,32,44,12,-2,-1};
        int n = arr.length;
        int smallest = arr[0];
        int sSmall = Integer.MAX_VALUE;
        for(int i=1; i<n; i++) {
            if(arr[i]<smallest) {
                sSmall = smallest;
                smallest = arr[i];
            }
            else if(arr[i] > smallest && arr[i]<sSmall) {
                sSmall = arr[i];
            }
        }
        System.out.println("Second Largest: "+ sSmall);
    }
}
