package Medium;

public class M5_Stocks_buy_and_sell {

    public static void main(String[] args) {
        int[] a = {7,1,5,3,6,4};
        int n = a.length;
//        getMaxProfit_1(a,n);
        getMaxProfit_2(a,n);
    }


    //bruteforce Approach
    //TC: O(N^2), SC: O(1)
    static void getMaxProfit_1(int[] a, int n) {
        int maxProfit = 0;
        int buyPrice = 0;
        int sellPrice = 0;
        for(int i =0; i<n ; i++){
            for(int j=i+1; j<n; j++){
                if(a[j] > a[i]) {
                    int diff = a[j] - a[i];
                    maxProfit = Math.max(diff, maxProfit);
                    if(diff == maxProfit) {
                        buyPrice = a[i];
                        sellPrice = a[j];
                    }
                }
            }
        }
        System.out.println("Solution1: buyPrice -> " + buyPrice);
        System.out.println("           sellPrice -> " + sellPrice);
        System.out.println("           MaxProfit -> " + maxProfit);
    }


    //OptimalApproach  -> compare the min buy price from left array
    //Tc: O(N)  , SC:O(1)
    static void getMaxProfit_2(int[] a, int n) {
        int maxProfit = 0;
        int minBP = a[0];
        int buyPrice = 0;
        int sellPrice = 0;
        for(int i =1; i<n; i++) {
            int diff = a[i] - minBP;
            maxProfit = Math.max(diff, maxProfit);
            minBP = Math.min(a[i], minBP);
            if(maxProfit == diff) {
                buyPrice = minBP;
                sellPrice = a[i];
            }
        }
        System.out.println("Solution2: buyPrice -> " + buyPrice);
        System.out.println("           sellPrice -> " + sellPrice);
        System.out.println("           MaxProfit -> " + maxProfit);
    }


}
