package Medium;

import java.util.HashMap;
import java.util.Map;

public class M1_2SumProblem {

    // Find targetSUM is possible or not
    // And also find the pair between them
    public static void main(String[] args) {
        int a[] = {2,6,5,8,11};
        int targetSum = 14;
//        twoSumBruteForce(a, a.length, targetSum);

        twoSumBetterApproach(a, a.length, targetSum);
    }

    //TC: O(N^2)
    static void twoSumBruteForce(int[] a, int n, int targetSum) {

        for(int i =0; i<n; i++) {
            for(int j = i+1; j<n ;j++){
                int sum = a[i] + a[j];
                if(sum == targetSum) {
                    System.out.println("Possible");
                    System.out.println("Pair: [ "+i +" , " +j +" ]");
                    break;
                }
            }
        }
    }

    static void twoSumBetterApproach(int[] a, int n, int targetSum) {
        Map<Integer, Integer> mapSum = new HashMap<>();
        for(int i = 0; i<n; i++) {
            int num = a[i];
            int rem = targetSum - num;
            if(mapSum.containsKey(rem)){
                System.out.println("Possible");
                System.out.println("Pair: [ "+i +" , " +mapSum.get(rem) +" ]");
                break;
            }
            else {
                mapSum.put(num, i);
            }
        }
    }


}
