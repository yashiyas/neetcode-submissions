class Solution {
    public int minDistance(String word1, String word2) {

        int n1 = word1.length();
        int n2 = word2.length();

        int[][] dp = new int[n1+1][n2+1];

        for(int j=n2; j>=0; j--){

            dp[n1][n2-j]=j;

        }

        for(int i=n1; i>=0; i--){
            dp[n1-i][n2] = i;
        }

        for(int i=n1-1; i>=0; i--){
            for(int j=n2-1; j>=0; j--){
                if(word1.charAt(i) == word2.charAt(j)){
                    dp[i][j] = dp[i+1][j+1];
                }else{
                    int insert = 1+dp[i][j+1];
                    int remove = 1+dp[i+1][j];
                    int replace = 1+dp[i+1][j+1];
                    dp[i][j] = Math.min(insert, Math.min(remove,replace));
                }
            }
        }

        return dp[0][0];

        
    }
}
