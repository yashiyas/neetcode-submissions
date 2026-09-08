class Solution {
    public int numIslands(char[][] grid) {

        int ans = 0; 
        int rowSize = grid.length;
        int colSize = grid[0].length;

        boolean[][] visited = new boolean[rowSize][colSize];
        Queue<int[]> bfs = new LinkedList();

        int[][] dir = {
            {0,1}, {1,0}, {0,-1}, {-1,0}
        };

        for(int i=0; i<rowSize; i++){
            for(int j=0; j<colSize; j++){
                if(!visited[i][j] && grid[i][j] == '1'){
                    dfs(i,j,grid,visited);
                    ans++;
                }
            }
        }

        return ans;
        
    }

    private void dfs(int row, int col, char[][] grid, boolean[][] visited){
        if(!isValid(row, col, grid.length, grid[0].length) || visited[row][col] || grid[row][col] == '0'){
            return;
        }

        visited[row][col] = true;

        
            dfs(row, col+1, grid, visited);
            dfs(row+1, col, grid, visited);
            dfs(row-1, col, grid, visited);
            dfs(row, col-1, grid, visited);
        


        
    }

    private boolean isValid(int newRow, int newCol, int rowSize, int colSize){
        return newRow >=0 && newCol >= 0 && newRow < rowSize && newCol < colSize;
    }
}
