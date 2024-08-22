package Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class E1_LargestIntArray {

    //Largest number in the array
    // Solution1 Sort + print(arr[n-1]) => Brute  O(NlogN)
    //Solution2 compare and print => optimal O(N)
    // note: O(1) < O(logN) < O(n) < O(NLogN)

    public static void main(String[] args) {

        int[] arr = {2,5,3,7,2,5,7,4,3,1,3,5,6,342,345,53,32,44,12};
        int n = arr.length;
        System.out.println(Arrays.toString(arr));
        optimalSol(arr);
        bruteSol1(arr); // quickSort
        System.out.println("QuickSort "+Arrays.toString(arr));
        System.out.println(arr[n-1]);
        int[] arr2 = {2,5,3,7,2,5,7,4,3,1,3,5,6,342,345,53,32,44,12};
        bruteSol2(arr2); //MergeSort
        System.out.println(arr2[n-1]);
    }

    static void optimalSol(int[] arr) {
        int largest = arr[0];
        for (int j : arr) {
            if (j > largest) {
                largest = j;
            }
        }
        System.out.println(largest);
    }


    static void bruteSol1(int[] arr) {
        //Using Quick Sort <= P <
        qSort(arr, 0, arr.length-1);
    }

    static void qSort(int[] a, int low, int high) {
        if(low<high) {
            int p = partition(a,low,high);
            qSort(a, low, p-1);
            qSort(a, p+1, high);
        }
    }

    static int partition(int[] a, int low, int high) {
        int pivot = a[low];
        int i = low;
        int j = high;

        while(i<j) {
            while(a[i]<= pivot && i<= high-1) { i++; }

            while(a[j]>pivot && j>=low+1) { j--; }

            if(i<j) { swap(a,j,i); }
        }
        swap(a,low,j);
        return j;
    }

    public static void swap(int a[], int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    static void bruteSol2(int[] a) {
        int n = a.length;
        int mid = (n-1)/2;
        mSort(a, 0,mid);
        mSort(a,mid+1,n-1);
        merge(a,0, mid, n-1);
        System.out.println("MergeSort" + Arrays.toString(a));
    }

    static void mSort(int[] a, int low, int high) {

        if(low>=high) return;
        int mid = (low + high)/2;
        mSort(a, low, mid);
        mSort(a, mid+1, high);
        merge(a, low, mid,high );

    }

    static void merge(int[] a, int low, int mid, int high) {

        List<Integer> tempList = new ArrayList<>();
        int left = low;
        int right = mid +1;

        while(left<=mid && right<=high) {
            if (a[left]<= a[right]) {
                tempList.add(a[left]);
                left++;
            } else {
                tempList.add(a[right]);
                right++;
            }
        }
        while(left<=mid) {
            tempList.add(a[left]);
            left++;
        }
        while(right<=high){
            tempList.add(a[right]);
            right++;
        }
        for(int i = low; i<=high ; i++) {
            a[i] = tempList.get(i - low);
        }
    }

}
