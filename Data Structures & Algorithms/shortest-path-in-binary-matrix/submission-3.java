class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {

        int n = grid.length;

        if(grid[0][0] == 1 || grid[n-1][n-1] == 1){
            return -1;
        }

        boolean[][] visited = new boolean[n][n];

        Queue<int[]> bfs = new LinkedList();
        bfs.offer(new int[]{0,0});
        visited[0][0] = true;

        int currPath = 0;

        int[][] dir = {
    {1,0}, {-1,0},
    {0,1}, {0,-1},
    {-1,-1}, {-1,1},
    {1,-1}, {1,1}
};

        while(!bfs.isEmpty()){
            int size = bfs.size();
            currPath++;
            for(int i=0; i<size; i++){
                int[] top = bfs.poll();
                if(grid[top[0]][top[1]] == 1){
                    continue;
                }
                else{
                    if(top[0] == n-1 && top[1] == n-1){
                        return currPath;
                    }
                    for(int[] d: dir){
                        int newRow = top[0]+d[0];
                        int newCol = top[1]+d[1];

                        if(isValid(newRow,newCol,grid,visited)){
                            visited[newRow][newCol] = true;
                            bfs.offer(new int[]{newRow,newCol});
                        }
                    }
                }
            }

        }

        return -1;
        
    }

    private boolean isValid(int row, int col, int[][] grid, boolean[][] visited){
        return (row>=0 && col >= 0 && row < grid.length && col < grid.length && !visited[row][col] && grid[row][col] == 0);
    }
}