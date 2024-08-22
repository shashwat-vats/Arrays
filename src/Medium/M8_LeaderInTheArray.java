package Medium;

import java.util.TreeSet;

public class M8_LeaderInTheArray {

    public static void main(String[] args) {
        int[] a = {10,22,12,3,0,6};
        int n = a.length;
        printLeader_1(a,n);
        printLeaderSet(a,n);
    }

    //BruteForce Approach
    //T.c: O(N^2)
    //S.C: O(N)
   static void printLeader_1(int[] a, int n) {
        TreeSet<Integer> leadSet = new TreeSet<>();

        for(int i=0; i<n ; i++){
            boolean leader = true;
            for(int j=i+1; j<n ; j++) {
                if(a[j]>a[i]) {
                    leader = false;
                    break;
                }
            }
            if(leader){
                leadSet.add(a[i]);
            }
        }
        System.out.println(leadSet);
   }

   //TC: O(N)
    // S.c: O(N)
   static void printLeaderSet(int[] a, int n) {
        int max = Integer.MIN_VALUE;
        TreeSet<Integer> leadSet = new TreeSet<>();
        for(int i=n-1; i>=0; i--) {
            if(a[i]>max){
                leadSet.add(a[i]);
            }
            max = Math.max(max, a[i]);
        }
        System.out.println(leadSet);
   }

}
