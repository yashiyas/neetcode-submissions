class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {

        if(s3.length() != s1.length()+s2.length()){
            return false;
        }
        int n1 = s1.length();
        int n2 = s2.length();

        Boolean[][] dp = new Boolean[n1+1][n2+1];

        return solve(0,0,s1,s2,s3,dp);

    }

    private boolean solve(int i, int j, String s1, String s2, String s3,
                      Boolean[][] dp) {

    if (i == s1.length() && j == s2.length()) {
        return true;
    }

    if (dp[i][j] != null) {
        return dp[i][j];
    }

    int k = i + j;

    boolean ans = false;

    if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) {
        ans = solve(i + 1, j, s1, s2, s3, dp);
    }

    if (!ans && j < s2.length() && s2.charAt(j) == s3.charAt(k)) {
        ans = solve(i, j + 1, s1, s2, s3, dp);
    }

    return dp[i][j] = ans;
}
}
