package Medium;

import java.util.Arrays;

import static Easy.E1_LargestIntArray.swap;

public class M2_sort_0s_1s_2s {


    public static void main(String[] args) {
        int[] a = {2,0,1,1,2,0,0,1,2,0,1,1};
        int n = a.length;
//        bubbleSort(a,n);
//        betterSolution(a,n);
        optimalSolution(a,n);
    }

    //bruteForce
    //Tc: O(N^2), SC: O()
    static void bubbleSort(int[] a, int n) {
        for(int i =n-1; i>1; i--) {
            boolean swapCheck = false;
            for(int j=0; j<i; j++) {
                if(a[j] > a[j+1])
                {
                    swap(a, j,j+1);
                    swapCheck = true;
                }
            }
            if(!swapCheck) {
                System.out.println("Stop Swaping");
                break;
            }
            System.out.println("Swaping...");
        }
        System.out.println(Arrays.toString(a));

    }

    //BetterSolution
    // TC: O(2N), O(N)

    static void betterSolution(int[] a, int n) {
        int count0 = 0;
        int count1 = 0;
        int count2 = 0;

        for(int i=0; i<n; i++) {
            if(a[i]==0) count0++;
            if(a[i]==1) count1++;
            if(a[i]==2) count2++;
        }

        for(int i=0; i<=n; i++) {
            if(i<count0) a[i] = 0;
            else if(i<count0+count1) a[i] = 1;
            else if(i<count0+count1+count2) a[i] = 2;
        }
        System.out.println(Arrays.toString(a));
    }

    /*
    optimalSolution
     TC: O(N)
    Dutch National Flag Algorithm
     there will be 3 pointers low, mid and high
     low = 0, mid = 0, high = n-1
     lows: 0 -> a[mid] == 0 , swap(a[low], a[mid]) , low++, mid++
     mids: 1 -> a[mid] == 1 , mid ++
     highs:2 -> a[mid] == 2 , swap(a[mid], a[high], high--)
    */
    //TC: O(N), SC: O(1)
    static void optimalSolution(int[] a, int n) {
        int low =0, mid = 0, high = n-1;

        while(mid<=high) {
            if(a[mid]==0) {
                swap(a,low,mid);
                low++;
                mid++;
            }
            else if(a[mid]==1) mid++ ;
            else if(a[mid]==2) {
                swap(a,mid,high);
                high--;
            }
        }
        System.out.println(Arrays.toString(a));
    }
}
