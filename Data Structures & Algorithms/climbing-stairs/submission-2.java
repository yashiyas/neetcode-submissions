class Solution {
    public int climbStairs(int n) {

        if(n <= 2){
            return n;
        }

        int[] dp = new int[]{1,2};

        for(int i=3; i<=n; i++){
            int curr = dp[0]+dp[1];
            int temp = dp[1];
            dp[1] = curr;
            dp[0] = temp;
        }

        return dp[1];
        
    }
}
