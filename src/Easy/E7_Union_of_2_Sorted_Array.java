package Easy;

import java.util.HashSet;
import java.util.Set;

public class E7_Union_of_2_Sorted_Array {
    public static void main(String[] args) {
        int[] a1 = {1,2,4,6,8};
        int[] a2 = {2,3,4,5,6,7};
        getUnionWithOptimalSolution(a1, a2, a1.length, a2.length);
    }

    //betterApproach
    //2 pointer solution
    static void getUnionWithOptimalSolution(int[] a1, int[] a2, int n1, int n2) {
        int i = 0;
        int j = 0;
        Set<Integer> union = new HashSet<>();
        while(i<n1 && j<n2) {
            if(a1[i]<=a2[j]) {
                if(union.isEmpty() || !union.contains(a1[i])) union.add(a1[i]);
                i++;
            } else {
                if(union.isEmpty() || !union.contains(a2[j])) union.add(a2[j]);
                j++;
            }
        }
        if(i<n1) {
            System.out.println("a1 elements are left");
            addLeftOver(union, a1, i, n1);
        }
        if(j<n2) {
            System.out.println("a2 elements are left");
            addLeftOver(union, a2, j, n2);
        }
        System.out.println(union);

    }


    static void addLeftOver(Set<Integer> unionSet, int[] a, int s, int n) {
        for (int i = s; i<n ; i++) {
            unionSet.add(a[i]);
        }
    }
}
