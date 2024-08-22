package Medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class M7_Next_Greater_Permutation {

    public static void main(String[] args) {
        List<Integer> aList = Arrays.asList(2,1,5,4,3,0,0);
        int n = aList.size();
        List<Integer> nextPList = nextP(aList,n);
        System.out.println(nextPList);


    }


    static List<Integer> nextP(List<Integer> aList, int n) {
        int index = -1;
        //find the breakpoint
        for(int i=n-2; i>=0 ; i--) {
            if(aList.get(i)<aList.get(i+1)){
                index = aList.get(i);
                break;
            }
        }
        if(index == -1) {
            Collections.reverse(aList);
            return aList;
        }

        for(int i=n-1; i>index; i--) {
            if(aList.get(i) > aList.get(index)) {
                Collections.swap(aList, i, index);
                break;
            }
        }
        List<Integer> subList = aList.subList(index+1,n);
        Collections.reverse(subList);
       // System.out.println(subList);
        return aList;
    }
}
