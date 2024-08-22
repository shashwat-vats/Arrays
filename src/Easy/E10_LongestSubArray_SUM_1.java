package Easy;

import java.util.HashMap;
import java.util.Map;

public class E10_LongestSubArray_SUM_1 {
    // Find the length of the longest sub Array
    //  containing only positive numbers
    // TC:
    public static void main(String[] args) {
        int[] a = {1, 1, 2, 1, 1, 1, 1, 2, 2, 2, 2,3, 4, 2};
        int sum = 14;
        int n = a.length;
        bruteApproach(a,sum,n);
        int targetSum = 1;
        int[] b = {1, 1, 0,0,0, 1, 1, 0,2, 2, 2, 2,3, 4, 2};
        optimalApproach(b,n,targetSum);

    }
    static void bruteApproach(int a[], int sum, int n) {
        int len = 0;
        for (int i = 0; i < n; i++) {
            int subSum = 0;
            for (int j = i; j < n; j++) {
                subSum = subSum + a[j];
                if (subSum == sum && len <= j-i+1) {
                    len = j-i+1;
                }
            }
        }
        System.out.println("Longest Sub Array of given sum "+ sum+" is " +len);
    }

    //
    static void optimalApproach(int[] a, int n, int targetSum) {
        Map<Integer, Integer> map = new HashMap<>();
        int currentSum = 0;
        int maxLen = 0;

        for(int i =0 ; i<n; i++) {
            currentSum += a[i];
            //checking if currentSum is equal to targetSum
            if(currentSum == targetSum) {
                maxLen = i +1;
            }

            //Difference of currentSum - targetSum
            int rem = currentSum - targetSum;
            if(map.containsKey(rem)) {
                int len = i - map.get(rem); // difference of current index and last index at which rem sum is present in sumMap
                maxLen = Math.max(maxLen,len);
            }

            if(!map.containsKey(currentSum)) {
                map.put(currentSum, i);
            }

        }

        System.out.println("Longest Sub Array of target sum "+ targetSum+" is " +maxLen);

    }

}

