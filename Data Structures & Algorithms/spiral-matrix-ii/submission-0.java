class Solution {
    public int[][] generateMatrix(int n) {

        int[][] ans = new int[n][n];

        int row = 0;
        int col = 0;

        int curr = 1;

        while(row <n && col < n){
            for(int j=col; j<n-col; j++){
                ans[row][j] = curr;
                curr++;
            }

            for(int k = row+1; k<n-row; k++){
                ans[k][n-col-1] = curr;
                curr++;
            }

            for(int j = n-col-2; j>=col; j--){
                ans[n-1-row][j] = curr;
                curr++;
            }

            for(int k = n-row-2; k>row; k--){
                ans[k][col] = curr;
                curr++;
            }

            row++;
            col++;
        }

        return ans;
        
    }
}