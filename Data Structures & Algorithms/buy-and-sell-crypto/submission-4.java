class Solution {
    public int maxProfit(int[] prices) {

        int buy = prices[0];
        int ans = 0;

        int i = 1;

        while(i<prices.length){

            if(buy > prices[i]){
                buy = prices[i];
            }else{
                ans = Math.max(ans, (prices[i] - buy));
            }

            i++;

        }

        return ans;
        
    }
}
