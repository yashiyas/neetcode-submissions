class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int firstHouse = nums[0]+robber(nums,2,n-2);
        int secondHouse = robber(nums,1,n-1);
        return Math.max(firstHouse,secondHouse);
    }

    private int robber(int[] nums, int start, int n){

        if(start > n){
            return 0;
        }

        int[] dp = new int[]{0,0};

        for(int i=start; i<=n; i++){
            int curr = Math.max(nums[i] + dp[0], dp[1]);
            dp[0] = dp[1];
            dp[1] = curr;
        }

        return dp[1];





    }
}
