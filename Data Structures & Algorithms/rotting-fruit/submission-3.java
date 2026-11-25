class Solution {
    public int orangesRotting(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];

        int t = 0;
        int fresh = 0;

        Queue<int[]> queue = new LinkedList();

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(grid[i][j] == 2){
                    visited[i][j] = true;
                    queue.offer(new int[]{i,j});
                }
                if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }

        int[][] directions = new int[][]{
            {0,1}, {0,-1}, {1,0}, {-1,0}
        };

        while(!queue.isEmpty() && fresh>0){
            t++;
            int size = queue.size();
            
            for(int i=0; i<size; i++){
                int[] curr = queue.poll();

                for(int[] dir: directions){
                    int newX = curr[0]+dir[0];
                    int newY = curr[1]+dir[1];

                    if(isValid(newX,newY, visited, grid)){
                        visited[newX][newY] = true;
                        grid[newX][newY] = 2;
                        fresh--;
                        queue.offer(new int[]{newX, newY});
                    }
                }

            }
            

        }

        if(fresh == 0){
            return t;
        }

        return -1;
        
    }

    private boolean isValid(int x, int y, boolean[][] visited, int[][] grid){
        if(x < 0 || x>=grid.length || y<0 || y >= grid[0].length || visited[x][y]|| grid[x][y] != 1){
            return false;
        }
        return true;
    }
}
