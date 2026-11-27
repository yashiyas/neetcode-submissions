class Solution {
    public int rob(int[] nums) {
        int[][] memo = new int[nums.length][2];
        for(int i=0; i<nums.length; i++){
            memo[i][0] = -1;
            memo[i][1] = -1;
        }
        int from0 = dfs(1,nums,memo,0);
        int from1 = nums[0]+dfs(2,nums,memo,1);
        return Math.max(from0, from1);
    }

    private int dfs(int i, int[] nums, int[][] memo, int flag){

        if(i >= nums.length || (flag==1 && i>=nums.length-1)){
            return 0;
        }

        if(memo[i][flag] != -1){
            return memo[i][flag];
        }

        memo[i][flag] = Math.max((nums[i]+dfs(i+2, nums, memo, flag)), dfs(i+1, nums, memo, flag) );

        return memo[i][flag];



    }
}
