class Solution {
    public int orangesRotting(int[][] grid) {

        int freshFruits = 0;
        int rottenFruits = 0;
        int time = 0;

        int[][] dir = new int[][]{
            {1,0}, {-1,0}, {0,1}, {0,-1}
        };

        Queue<int[]> bfs = new LinkedList();

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 2){
                    bfs.offer(new int[]{i,j});
                    rottenFruits++;
                }else if(grid[i][j] == 1){
                    freshFruits++;
                }
            }
        }

        while(!bfs.isEmpty()){
            if(freshFruits == 0){
                return time;
            }
            int size = bfs.size();
            time++;
            for(int k=0; k<size; k++){
                int[] top = bfs.poll();
                for(int[] d: dir){
                    int newRow = top[0]+d[0];
                    int newCol = top[1]+d[1];

                    if(isValid(newRow,newCol,grid)){
                        grid[newRow][newCol] = 2;
                        freshFruits--;
                        bfs.offer(new int[]{newRow,newCol});
                    }
                }
            }
        }

        if(freshFruits == 0){
            return time;
        }

        return -1;
        
    }

    private boolean isValid(int row, int col, int[][] grid){
        return row>=0 && col >= 0 && row < grid.length && col < grid[0].length && grid[row][col] == 1;
    }
}
