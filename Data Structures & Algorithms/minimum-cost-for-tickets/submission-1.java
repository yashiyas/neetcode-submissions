class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        int[] dp = new int[n];

        for(int j=n-1; j>=0; j--){
            int days1 = findIndex(days,j,days[j]+1);
            int days2 = findIndex(days,j,days[j]+7);
            int days3 = findIndex(days,j,days[j]+30);

            int cost1 = costs[0]+(days1 <n ? dp[days1]: 0);
            int cost2 = costs[1]+(days2 <n ? dp[days2]: 0);
            int cost3 = costs[2]+(days3 <n ? dp[days3]: 0);

            dp[j] = Math.min(cost1,Math.min(cost2,cost3));
        }

        return dp[0];
        
    }

    private int findIndex(int[] days, int current, int cover){
        while(current <days.length && days[current] < cover){
            current++;
        }

        return current;
    }
}