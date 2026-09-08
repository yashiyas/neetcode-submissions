class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];

        for(int i=0; i<n; i++){
            dp[i][0] = 1;
        }

        for(int j=1; j<=amount; j++){
            int coin = coins[0];
            if(j%coin == 0){
                dp[0][j] = 1;
            }else{
                dp[0][j] = 0;
            }
        }

        for(int i=1; i<n; i++){
            int coin = coins[i];
            for(int j=1; j<=amount; j++){
                if(coin > j){
                    dp[i][j] = dp[i-1][j];
                }else{
                    int rem = j-coin;
                    dp[i][j] = dp[i-1][j]+dp[i][rem];
                }
            }
        }

        return dp[n-1][amount];
        
    }
}
