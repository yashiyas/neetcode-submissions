class Solution {
    public int maxProfit(int[] prices) {

        int n = prices.length;
        int[] maxArray = new int[n];

        maxArray[n-1] = prices[n-1];

        for(int i=n-2; i>=0; i--){
            maxArray[i] = Math.max(prices[i], maxArray[i+1]);
        }

        int ans = 0;

        for(int i=0; i<n; i++){
            int currProfit = maxArray[i] - prices[i];
            ans = Math.max(ans, currProfit);
        }

        return ans;
        
    }
}
