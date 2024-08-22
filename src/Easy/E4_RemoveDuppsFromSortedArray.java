package Easy;

public class E4_RemoveDuppsFromSortedArray {
//Using 2 pointer method
    public static void main(String[] args) {
//                   i   j
        int[] a = {1,2,2,3,4,4,5,6,6,7,8,8,9};
        //            a[j]
        int n = a.length;

        int i =0;

        for(int j = 1; j<n; j++){
            if(a[i] != a[j]) {
                a[i+1] = a[j];
                i++;
            }
        }

        for(int k = 0 ; k<i+1; k++){
            System.out.print(a[k] + " ");
        }


    }
}
