class Solution {
    public int minCostClimbingStairs(int[] cost) {

        int[] memo = new int[cost.length];

        for(int i=0; i<cost.length; i++){
            memo[i] = -1;
        }

        return Math.min(dfs(0,cost, memo), dfs(1,cost, memo));

        
    }

    private int dfs(int i, int[] cost, int[] memo){
        if(i >= cost.length){
            return 0;
        }

        if(memo[i] != -1){
            return memo[i];
        }

        memo[i] = cost[i] + Math.min(dfs(i+1,cost, memo), dfs(i+2,cost, memo));
        return memo[i];
    }
}
