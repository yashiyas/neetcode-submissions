class Solution {
    public int swimInWater(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];

        PriorityQueue<Cell> pq = new PriorityQueue<>((a,b)->a.time-b.time);
        int ans = 0;

        int[][] dir = new int[][]{
            {0,1}, {0,-1}, {1,0}, {-1,0}
        };

        pq.offer(new Cell(0,0,grid[0][0]));
        visited[0][0] = true;


        while(true){
            Cell top = pq.poll();
            ans = Math.max(ans,top.time);
            if(top.row == m-1 && top.col == n-1){
                return ans;
            }
            int row = top.row;
            int col = top.col;

            for(int i=0; i<4; i++){
                int newRow = row + dir[i][0];
                int newCol = col + dir[i][1];
                if(isValid(newRow,newCol,grid) && !visited[newRow][newCol]){
                    visited[newRow][newCol] = true;
                    pq.offer(new Cell(newRow, newCol, grid[newRow][newCol]));
                }
            }
        }
        
    }

    private boolean isValid(int r, int c, int[][] grid){
        return(r>=0 && c>=0 && r<grid.length && c< grid[0].length);
    }

    class Cell{
        int row;
        int col;
        int time;

        Cell(int r, int c, int time){
            this.row = r;
            this.col = c;
            this.time = time;
        }
    }
}
