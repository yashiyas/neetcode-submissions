class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];

        for(int i =1; i<=amount; i++){
            int coin = coins[0];
            if(i%coin != 0){
                dp[0][i] = amount+1;
            }else{
                dp[0][i] = i/coin;
            }
        }

        for(int c=1; c<n; c++){
            int coin = coins[c];
            for(int i=1; i<=amount; i++){
                // included
                if(i<coin){
                    dp[c][i] = dp[c-1][i];
                }else{
                    int rem = i-coin;
                    dp[c][i] = Math.min(1+dp[c][rem], dp[c-1][i]);
                }
            }
        }

        if(dp[n-1][amount] == amount+1){
            return -1;
        }

        return dp[n-1][amount];
        
    }
}