class Solution {
    public int maxA(int n) {
        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            dp[i] = dp[i - 1] + 1; // Type A

            for (int j = 1; j <= i - 3; j++) {
                // At j presses: dp[j] A's.
                // Then Ctrl-A, Ctrl-C, followed by (i-j-2) pastes.
                dp[i] = Math.max(dp[i], dp[j] * (i - j - 1));
            }
        }

        return dp[n];
    }
}