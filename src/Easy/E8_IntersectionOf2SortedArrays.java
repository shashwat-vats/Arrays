package Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class E8_IntersectionOf2SortedArrays {

    public static void main(String[] args) {
        int[] lArr = {1,3,4,6,7,7,9,20};
        int[] sArr = {1,2,3,4,5,6};
        int[] vArray = new int[sArr.length];
        bruteForce(lArr,sArr,vArray);
        optimalSolution(lArr,sArr, lArr.length, sArr.length);
    }

    //TC: O(n1*n2)
    static void bruteForce(int[] lArr, int[] sArr, int[] vArray) {
        int[] interArr = new int[sArr.length];
        for(int i =0; i<lArr.length; i++){
            for (int j = 0; j<sArr.length; j++) {
                if(sArr[j]>lArr[i]) {
                    break;
                }
                if(sArr[j]==lArr[i] && vArray[j]==0) {
                    interArr[i] = sArr[j];
                    vArray[j] = 1;
                    break;
                }

            }
        }

        System.out.println(Arrays.toString(interArr));

    }

    //2pointer approach
    //TC: O(n1+n2), SC: O(1) // we are using any extra space to solve the problem
    static void optimalSolution(int[] a, int[] b, int n1, int n2) {
        int i=0;
        int j=0;
        List<Integer> interList = new ArrayList<>();
        while(i<n1 && j<n2) {
            if(a[i]<b[j]) i++;
            if(a[i]>b[j]) j++;
            else {
                interList.add(a[i]);
                i++;
                j++;
            }
        }
        System.out.println(interList);
    }

}
