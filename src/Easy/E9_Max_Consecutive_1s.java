package Easy;

public class E9_Max_Consecutive_1s {

    public static void main(String[] args) {
        int[] a = {1,1,0,0,1,1,1,0,1,1};
        int count = 0;
        int max = 0;
        for(int i=0; i<a.length; i++) {
            if(a[i]==1){
                count++;
                if(count > max) max = count;
            }
            else {
                count = 0;
            }
        }
        System.out.println(max);
    }
}
