package Medium;

import java.util.HashMap;
import java.util.Map;

public class M11_Count_subArrays_with_sum_k {

    public static void brute_better(int[] a, int n, int k) {
       //T.C: O(N^2), SC: O(N)
        int count = 0;
        for(int i = 0; i<n ; i++) {
            int sum = 0;
            for(int j = i; j<n ; j++) {
                sum += a[j];
                if(sum==k) {
                    count++;
                }
            }
        }
        System.out.println("Number of SubArrays with sum " + k + " is " + count);
    }

    public static void optimal(int[] a, int n, int k) {
        //TC:O(N) , SC: O(N)
        int count = 0;
        int preSum = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);

        for(int i=0 ; i<n ; i++) {
            preSum += a[i];
            int diff = preSum - k;
            count += map.getOrDefault(diff, 0);
            map.put(preSum, map.getOrDefault(preSum,0)+1);
        }
        System.out.println("Number of SubArrays with sum " + k + " is " + count);
    }





    public static void main(String[] args) {
        int[] a = {1,2,3,-3,1,1,1,4,2,-3};
        int k = 3;
        int n = a.length;
        brute_better(a,n,k);
        optimal(a,n,k);
    }

}
