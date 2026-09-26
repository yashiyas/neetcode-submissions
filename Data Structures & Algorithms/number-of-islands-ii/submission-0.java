class Solution {
    private static int[][] directions = new int[][]{
        {1,0}, {-1,0}, {0,1}, {0,-1}
    };

    public List<Integer> numIslands2(int m, int n, int[][] positions) {

        int[][] grid = new int[m][n];

        List<Integer> ans = new ArrayList();

        for(int[] land: positions){
            grid[land[0]][land[1]] = 1;
            boolean[][] visited = new boolean[m][n];
            int islands = getIslands(grid, visited);
            ans.add(islands);
        }

        return ans;
        
    }

    private int getIslands(int[][] grid, boolean[][] visited){
        int ans = 0;

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                int cell = grid[i][j];
                if(!visited[i][j] && cell==1){
                    ans++;
                    bfs(grid, i, j, visited);
                }
            }
        }

        return ans;
    }

    private void bfs(int[][] grid, int x, int y, boolean[][] visited){
        Queue<int[]> queue = new LinkedList();
        visited[x][y] = true;
        queue.offer(new int[]{x,y});

        while(!queue.isEmpty()){
            int[] curr = queue.poll();

            for(int i=0; i<4; i++){
                int newX = curr[0]+directions[i][0];
                int newY = curr[1]+directions[i][1];

                if(isValid(newX,newY,grid) && !visited[newX][newY]){
                    visited[newX][newY] = true;
                    queue.offer(new int[]{newX, newY});
                }
            }
        }
    }

    private boolean isValid(int x, int y, int[][] grid){
        if(x < 0 || y<0 || x>=grid.length || y>=grid[0].length){
            return false;
        }
        return grid[x][y] == 1;
    }
}
