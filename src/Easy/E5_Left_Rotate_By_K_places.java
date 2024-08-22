package Easy;

import java.util.Arrays;

public class E5_Left_Rotate_By_K_places {

    //brute force with tc: O(N) and SC: O(N)

    public static void main(String[] args) {
        int b[] = {2,5,3,7,2,5,7,0,4,3,-2,-1};
        int n1 = b.length;
        int k = 3;
        if (k%n1 != 0) {
            rotateleftbyK(b,n1,k%n1);
        }

        //optimal solution
        int a[] = {2,5,3,7,2,5,7,0,4,3,-2,-1};
        int n2 = b.length;
        reverse(a,0,k-1);
        reverse(a,k, n2-1);
        reverse(a,0,n2-1);
        System.out.println(Arrays.toString(a));
    }

    static void rotateleftbyK(int a[], int n, int k) {

        int temp[] = new int[k];
        for(int i = 0; i<k ; i++) {
            temp[i] = a[i];
        }

        for(int i = k; i < n ; i++) {
            a[i-k] = a[i];
        }

        for(int i = n-k; i<n; i++) {
            a[i] = temp[i - (n-k)];
        }

        System.out.println(Arrays.toString(a));


    }


    //optimalSolution
    public static void reverse(int[] a, int s, int e) {
        while(s<=e) {
            int temp = a[s];
            a[s] = a[e];
            a[e] = temp;
            s++;
            e--;
        }
    }









}
