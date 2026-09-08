class Solution {
    public int maxProfit(int[] prices) {
       int d = prices.length;
       int [] buy = new int[d];
       int [] sell = new int[d];

       for(int i=0; i<d; i++){
        if(i==0){
            buy[i] = prices[i];
        }
        else{
            buy[i] = Math.min(prices[i], buy[i-1]);
        }
       }

       for(int i=d-1; i>=0; i--){
        if(i==(d-1)){
            sell[i] = prices[i];
        }
        else{
            sell[i] = Math.max(prices[i], buy[i+1]);
        }
       }

        int profit = 0;

        for(int i=0; i<d; i++){
            profit = Math.max(profit ,sell[i] - buy[i]);
        }

        return profit;
       

    }
}
