class Solution {
public:
    int minDistance(string word1, string word2) {
        int n1 = word1.length();
        int n2 = word2.length();

        vector<vector<int>> dp(n1+1, vector<int>(n2+1));
        for(int i=0; i<=n1; i++){
            dp[i][0] = i;
        }

        for(int i=0; i<=n2; i++){
            dp[0][i] = i;
        }

        for(int i=1; i<=n1; i++){
            for(int j=1; j<=n2; j++){
                if(word1[i-1] == word2[j-1]){
                    dp[i][j] = dp[i-1][j-1];
                }
                else{
                    int insert = dp[i][j-1];
                    int rem = dp[i-1][j];
                    int rep = dp[i-1][j-1];
                    int ans = min(insert,rem);
                    ans = min(ans, rep);
                    dp[i][j] = 1+ ans;
                }
            }
        }

        return dp[n1][n2];
    }

    int findDistance(string word1, string word2, int n1, int n2){
        if(n1 == 0){
            return n2;
        }

        if(n2 == 0){
            return n1;
        }

        if(word1[n1-1] == word2[n2-1]){
            return findDistance(word1, word2, n1-1, n2-1);
        }

        int insert = 1+findDistance(word1, word2, n1, n2-1);
        int del = 1+findDistance(word1, word2, n1-1, n2);
        int repl = 1+findDistance(word1, word2, n1-1, n2-1);
        int res = min(insert,del);
        res = min(res, repl);
        return res;
    }
};
