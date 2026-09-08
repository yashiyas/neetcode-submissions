class Solution {
    public int maxProfit(int[] prices) {

        int n = prices.length;

        if(n<=1){
            return 0;
        }

        int profit = 0;

        int i=0;
        int j=1;

        while(i<n && j<n){
            if(prices[i] > prices[j]){
                i=j;
                j++;
            }
            else{
                profit = Math.max(profit, prices[j]-prices[i]);
                j++;
            }
        }

        return profit;
        
    }
}
