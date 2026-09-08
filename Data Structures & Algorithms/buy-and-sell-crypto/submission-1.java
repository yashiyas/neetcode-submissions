class Solution {
    public int maxProfit(int[] prices) {
       int d = prices.length;
       int profit = 0;

       int i=0;
       int j=1;

       while(i<j && j<d){
            if(prices[j] < prices[i]){
                i=j;
                j++;
            }
            else{
                int curr = prices[j] - prices[i];
                profit = Math.max(profit, curr);
                j++;
            }
       }

       return profit;

       

    }
}
