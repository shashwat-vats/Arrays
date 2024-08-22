package Medium;

import java.util.Arrays;
import java.util.TreeSet;

public class M9_Longest_Consecutive_Sequence {

    public static void main(String[] args) {
        int[] a = {102,4,103,1,100,101,3,2,2,1,1};
        int n = a.length;
        better(a,n);
//        optimal(a,n);
    }

    //TC: ~ O(2N)
    static void better(int[] a, int n) {
        int longest = 0;
        int last = Integer.MIN_VALUE;
        int count = 0;
        Arrays.sort(a); // O(N)
        for(int i=0; i<n ; i++) { //O(N)
            if(a[i]-1 == last) {
                count++;
                last = a[i];
            }
            else if(a[i]!=last) {
                count = 1;
                last = a[i];
            }
            longest = Math.max(longest,count);
        }

        System.out.println(longest);

    }
//
//    static void optimal(int[] a, int n) {
//
//    }

}
