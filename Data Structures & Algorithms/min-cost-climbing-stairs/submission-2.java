class Solution {
    public int minCostClimbingStairs(int[] cost) {

        int n = cost.length;
        int[] cache = new int[n];
        Arrays.fill(cache,-1);


        return Math.min(reachNstep(cost,n-1,cache), reachNstep(cost,n-2,cache));
        
    }

    private int reachNstep(int [] cost, int i, int[] cache){
        if(i<0){
            return 0;
        }
        if(i<=1){
            return cost[i];
        }

        if(cache[i] != -1){
            return cache[i];
        }

        int x = Math.min((cost[i]+reachNstep(cost,i-2,cache)), (cost[i]+reachNstep(cost,i-1,cache)));
        cache[i] = x;
        return cache[i];
    }
}
