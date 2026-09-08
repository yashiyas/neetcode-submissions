class Solution {
    public boolean canPartition(int[] nums) {

        int n = nums.length;

        if(n<=1){
            return false;
        }

        int sum = 0;

        for(int i=0; i<n; i++){
            sum+=nums[i];
        }

        if(sum%2 != 0){
            return false;
        }

        int hsum = sum/2;

        return partition(hsum,nums);
        
    }

    private boolean partition(int target, int[] nums){
        int n = nums.length;

        boolean[][] dp = new boolean[n][target+1];

        dp[0][nums[0]] = true;

        for(int i=0; i<n; i++){
            dp[i][0] = true;
        }

        for(int i=1; i<n; i++){
            int val = nums[i];
            for(int j=1;j<=target;j++){
                int rem = j-val;
                if(rem<0){
                    dp[i][j] = dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][rem] || dp[i-1][j];
                }
            }
        }

        return dp[n-1][target];
    }
}
