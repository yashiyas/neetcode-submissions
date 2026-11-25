class Solution {
    public void islandsAndTreasure(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> queue = new LinkedList();

        boolean[][] visited = new boolean[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 0){
                    visited[i][j] = true;
                    queue.offer(new int[]{i,j});
                }
            }
        }

        int currDis = 0;

        int[][] directions = new int[][]{
            {1,0}, {-1,0}, {0,1}, {0,-1}
        };

        while(!queue.isEmpty()){
            int size = queue.size();

            for(int i=0; i<size; i++){

                int[] curr = queue.poll();

                for(int[] dir: directions){
                    int newX = dir[0]+curr[0];
                    int newY = dir[1]+curr[1];

                    if(isValid(newX, newY, grid, visited)){
                        grid[newX][newY] = grid[curr[0]][curr[1]] + 1;
                        visited[newX][newY] = true;
                        queue.offer(new int[]{newX, newY});
                    }
                }

            }
        }
        
    }

    private boolean isValid(int x, int y, int[][] grid, boolean[][] visited){
        if(x<0 || x>= grid.length || y<0 || y>= grid[0].length || visited[x][y] || grid[x][y] == -1){
            return false;
        }
        return true;
    }

    
}
