package Medium;

public class M4_Max_Sub_Array_Sum {

    //array[]

    public static void main(String[] args) {
        int[] a = {-2,-3,4,-1,-2,1,5,-3};
        int n = a.length;
        //bruteForceApproach
        maxSubArraySum_1(a,n);
        //Optimal Approach
        // Kadane's algo
        System.out.println();
        maxSubArraySum_2(a,n);

        int[] a2 = {0,0,0,0};
        int n2 = a2.length;
        System.out.println();
        maxSubArraySum_2(a2,n2);
    }



    //bruteForce ->
    //TC: O(N^2) ,  SC: O(1)
    static void maxSubArraySum_1(int[] a, int n) {
        int maxSubSum = 0;
        int start = 0;
        int end = 0;
        for(int i =0; i<n; i++) {
            int sum = 0;
            for(int j=i; j<n ; j++) {
                sum += a[j];
                if(sum>maxSubSum)
                {
                    maxSubSum = sum;
                    start = i;
                    end = j;
                }
            }

        }
        System.out.println(maxSubSum);
        for(int i = start ; i<=end ; i++){
            System.out.print(a[i]+",");
        }
    }

    //optimalSolution
    //Kadane's algo
    //if sum < 0 then sum = 0
    //T.C: O(N), SC: O(1)
    private static void maxSubArraySum_2(int[] a, int n) {
        int start = 0;
        int end = 0;
        int sum = 0;
        int maxSubSum = Integer.MIN_VALUE;
        for(int i =0; i<n; i++) {
            if(sum == 0) {
                start = i;
            }
            sum += a[i];
            if(sum > maxSubSum) {
                maxSubSum = sum;
                end = i;
            }
            if(sum<0) {
                sum=0;
            }
        }
            System.out.println(maxSubSum);
            for(int i = start; i<=end; i++){
                System.out.print(a[i]+",");
            }

    }



}
