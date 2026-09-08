class Solution {
public:
    int numIslands(vector<vector<char>>& grid) {
        int n = grid.size();
        int m = grid[0].size();
        vector<vector<bool>> visited(n, vector<bool>(m));
        int count = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    count++;
                    dfs(grid, i, j, m, n, visited);
                }
            }
        }

        return count;

    }

    void dfs(vector<vector<char>>& grid, int i, int j, int m, int n, vector<vector<bool>> &visited){
        if( i<0 || j<0 || i >=n || j >=m || grid[i][j] == '0' || visited[i][j]){
            return;
        }
        visited[i][j] = true;
        dfs(grid, i-1, j, m, n, visited);
        dfs(grid, i, j-1, m, n, visited);
        dfs(grid, i+1, j, m, n, visited);
        dfs(grid, i, j+1, m, n, visited);
    }
};
