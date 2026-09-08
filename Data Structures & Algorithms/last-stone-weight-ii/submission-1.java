class Solution {
    public int lastStoneWeightII(int[] stones) {

        int total = 0;
        int n = stones.length;

        for(int i=0; i<n; i++){
            total+=stones[i];
        }

        int half = total/2;

        boolean[][] dp = new boolean[n][half+1];

        for(int i=0; i<n; i++){
            dp[i][0] = true;
        }

        if (stones[0] <= half) {
            dp[0][stones[0]] = true;
        }

        for(int i=1; i<n; i++){
            for(int j=1; j<=half; j++){
                int weight = stones[i];
                if(weight > j){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-weight];
                }
            }
        }

        int reached = 0;

        for(int j=half; j>=0; j--){

            if(dp[n-1][j]){
                reached = j;
                break;
            }

        }

        return total - 2 * reached;

    }
}