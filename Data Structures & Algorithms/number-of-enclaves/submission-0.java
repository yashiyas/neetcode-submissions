class Solution {
    public int numEnclaves(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        boolean[][] visited = new boolean[n][m];

        int ans =0;

        for(int i=0; i<n; i++){
            if(grid[i][0] == 1 && !visited[i][0]){
                dfs(i,0,visited,grid);
            }
            if(grid[i][m-1] == 1 && ! visited[i][m-1]){
                dfs(i,m-1,visited,grid);
            }
        }

        for(int i=0; i<m; i++){
            if(grid[0][i] == 1 && !visited[0][i]){
                dfs(0,i,visited,grid);
            }

            if(grid[n-1][i] == 1 && !visited[n-1][i]){
                dfs(n-1,i,visited,grid);
            }
        }

        for(int i=1; i<n-1; i++){
            for(int j=1; j<m-1; j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                    ans++;
                }
            }
        }

        return ans;
        
    }

    private void dfs(int row, int col, boolean[][] visited,int[][] grid){
        if(visited[row][col]){
            return;
        }

        visited[row][col] = true;

        int[][] direction = new int[][]{
            {0,1}, {0,-1}, {1,0}, {-1,0}
        };

        for(int[] dir: direction){
            int newX = row+dir[0];
            int newY = col+dir[1];

            if(isValid(newX,newY,visited,grid)){
                dfs(newX,newY,visited,grid);
            }
        }
    }

    private boolean isValid(int x, int y, boolean[][] visited, int[][] grid){
        int n = grid.length;
        int m = grid[0].length;
        if(x<0 || y < 0 || x >=n || y>= m){
            return false;
        }

        return grid[x][y] == 1 && !visited[x][y];
    }
}