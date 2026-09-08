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
                    visited[i][j] = true;
                    int [] curr = {i,j};
                    bfs.offer(curr);
                    while(!bfs.isEmpty()){
                        int[] top = bfs.poll();

                        for(int k=0; k<4; k++){
                            int newRow = top[0]+dir[k][0];
                            int newCol = top[1]+dir[k][1];

                            if(isValid(newRow, newCol, rowSize, colSize) && !visited[newRow][newCol] && grid[newRow][newCol] == '1'){
                                bfs.offer(new int[]{newRow, newCol});
                                visited[newRow][newCol] = true;
                            }
                        }

                    }

                    ans++;
                }
            }
        }

        return ans;
        
    }

    private boolean isValid(int newRow, int newCol, int rowSize, int colSize){
        return newRow >=0 && newCol >= 0 && newRow < rowSize && newCol < colSize;
    }
}
