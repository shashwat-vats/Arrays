package Easy;

import java.util.Arrays;

public class E6_moveZeroestoEnd {

    public static void main(String[] args) {
        int[] a = {0, 0, 0, 1, 0, 3, 0, 0, 4, 2, 0, 1, 1};
        //moveOptimal1(a,a.length);
        moveBrute(a, a.length);
        System.out.println(Arrays.toString(a));
    }


    //2pointer solution 1
    //tc: O(n-1) ~ O(n)
    static void moveOptimal1(int a[], int n) {
        int j = 1;
        int i = 0;
        while (j < n) {
            if (a[i] != 0) {
                i++;
            } else if (a[i] == 0 && a[j] != 0) {
                int temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i++;
            }
            j++;
        }
    }

    //brute force approach
    //T.C: O(2N)
    static void moveBrute(int a[], int n) {
        int temp[] = new int[n];
        for (int i = 0; i < n; i++) {
            temp[i] = a[i];
        }
        int c = 0;
        for (int i = 0; i < n; i++) {
            if (temp[i] != 0) {
                a[c] = temp[i];
                c++;
            }
        }
        for (int i = c; i < n; i++) {
            a[i] = 0;
        }

    }

//    static void swap (int a[] ,int i ,int j) {
//        int temp = a[i];
//        a[i] = a[j];
//        a[j] = temp;
//    }


}
