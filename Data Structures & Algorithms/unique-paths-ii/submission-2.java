class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if(obstacleGrid[m-1][n-1] == 1 || obstacleGrid[0][0] == 1){
            return 0;
        }

        if(m==1 && n==1){
            return 1;
        }

        int[][] dp = new int[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                dp[i][j] = -1;
            }
        }

        dp[m-1][n-1] = 1;

        return fill(obstacleGrid,0,1,dp) + fill(obstacleGrid,1,0,dp);
        
    }

    private int fill(int[][] obstacleGrid, int row, int col, int[][] dp){

        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if(row == m || col == n){
            return 0;
        }

        if(dp[row][col] != -1){
            return dp[row][col];
        }

        if(obstacleGrid[row][col] == 1){
            return 0;
        }

        int t = fill(obstacleGrid,row,col+1,dp)+fill(obstacleGrid,row+1,col,dp);
        dp[row][col] = t;
        return t;

    }
}