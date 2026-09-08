class Solution {
    public int maxAreaOfIsland(int[][] grid) {

        int ans = 0;

        boolean [][] visited = new boolean[grid.length][grid[0].length];
        Queue<int[]> bfs = new LinkedList();
        int[][] dir = new int[][] {{1,0}, {-1,0}, {0,1}, {0,-1}};

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(!visited[i][j] && grid[i][j] == 1){
                    int currArea = 1;
                    bfs.offer(new int []{i,j});
                    visited[i][j] = true;

                    while(!bfs.isEmpty()){
                        int [] top = bfs.poll();

                        for(int k=0; k<4; k++){
                            int newRow = top[0]+dir[k][0];
                            int newCol = top[1]+dir[k][1];

                            if(isValid(newRow,newCol,grid,visited)){
                                visited[newRow][newCol] = true;
                                currArea++;
                                bfs.offer(new int []{newRow, newCol});
                            }
                        }

                    }

                    if(ans < currArea){
                        ans = currArea;
                    }

                }
            }
        }

        return ans;
        
    }

    private boolean isValid(int newRow, int newCol, int[][] grid, boolean[][] visited){
        return (newRow >=0 && newRow < grid.length && newCol >=0 && newCol < grid[0].length && grid[newRow][newCol] == 1 && !visited[newRow][newCol]);
    }
}
