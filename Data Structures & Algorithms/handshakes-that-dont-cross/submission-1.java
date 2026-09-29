class Solution {
    private static final int MOD = 1_000_000_007;

    public int numberOfWays(int numPeople) {
        int[] dp = new int[numPeople + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;

        return solve(numPeople, dp);
    }

    private int solve(int num, int[] dp) {
        if (dp[num] != -1) {
            return dp[num];
        }

        long curr = 0;

        for (int left = 0; left <= num - 2; left += 2) {
            int right = num - left - 2;

            curr = (curr + (long) solve(left, dp) * solve(right, dp)) % MOD;
        }

        dp[num] = (int) curr;
        return dp[num];
    }
}