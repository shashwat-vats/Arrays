package Medium;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class M6_Rearrange_nums_by_sign {
    //Variety1
    /*
    +ve and -ve nos will always be in equal nos
    rearrange +ve and -ve nos in alternative order (+,-,+,-)
    n/2 +ve nos
    n/2 -ve nos
     */
    public static void main(String[] args) {
        int[] a = {1,2,-3,-1,3,-4};
        int n = a.length;
//        rearrange1(a,n);
        int[] a2 = {1,2,-3,-1,3,-4};
        rearrange1(a2,n);
    }

    //brute force Approach
    //TC: O(n) + O (n/2) ~ O(n)
    //SC: O(n)
    static void rearrange(int[] a, int n) {
        List<Integer> posList = new ArrayList<>();
        List<Integer> negList = new ArrayList<>();

        for(int i=0 ; i<n ; i++) {
           if(a[i] < 0) {
               negList.add(a[i]);
           } else {
               posList.add(a[i]);
           }
        }
        System.out.println(posList);
        System.out.println(negList);

        for(int i=0 ; i<n/2 ; i++) {
            a[2*i] = posList.get(i);
            a[(2*i)+1]=negList.get(i);
        }

        System.out.println(Arrays.toString(a));
    }

    static void rearrange1(int[] a, int n){
        ArrayList<Integer> reList = new ArrayList<>(Collections.nCopies(n, 0));
        int pos =0; int neg = 1;
        for(int i=0; i<n ; i++){
            if(a[i]<0){
                reList.set(neg, a[i]);
                neg += 2;
            } else {
                reList.set(pos, a[i]);
                pos +=2;
            }
        }
        System.out.println(reList);
    }

}




class M6_Rearrange_nums_by_sign_v2 {
    /*
    Variety 2
    arrange in alternative order
    where +ve can be greater than -ve or vice versa
    remaining can be added as is.
     */
    public static void main(String[] args) {
        int[] a = {7,2,-3,-4,5,6};
        int n = a.length;
        arrange(a,n);
    }

    static void arrange(int[] a, int n) {
        List<Integer> posList = new ArrayList<>();
        List<Integer> negList = new ArrayList<>();
        List<Integer> tempList;
        for(int i=0 ; i<n ; i++) {
            if(a[i] < 0) {
                negList.add(a[i]);
            } else {
                posList.add(a[i]);
            }
        }
        int size;
        int end;
        if(posList.size()>negList.size()) {
            tempList = posList;
            size = negList.size();
            end = posList.size();
        } else {
            tempList = negList;
            size = posList.size();
            end = posList.size();
        }

        for(int i =0; i<size; i++) {
            a[2*i] = posList.get(i);
            a[2*i+1] = negList.get(i);
        }
        int index = 2*size;
        for (int i = size; i<end; i++ ){
            a[index] = tempList.get(i);
            index++;
        }

        System.out.println(Arrays.toString(a));
    }


}
