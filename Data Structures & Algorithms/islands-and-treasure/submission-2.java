class Solution {
    public void islandsAndTreasure(int[][] grid) {

        Queue<List<Integer>> queue = new LinkedList();

        for(int i=0; i<grid.length; i++){
            for(int j=0; j<grid[0].length; j++){
                if(grid[i][j] == 0){
                    queue.offer(List.of(i,j));
                }
            }
        }

        bfs(queue,grid);
        
    }

    private void bfs(Queue<List<Integer>> queue, int[][] grid){
        int distance = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
  

        int[][] directions = new int[][]{
            {0,1}, {0,-1}, {1,0}, {-1,0}
        };

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int k=0; k<size; k++){
                List<Integer> curr = queue.poll();
                int x = curr.get(0);
                int y = curr.get(1);
                visited[x][y] = true;
                if(grid[x][y] != -1 && grid[x][y] > distance){
                    grid[x][y] = distance;
                }
                for(int l=0; l<4; l++){
                    int newx = x+directions[l][0];
                    int newy = y+directions[l][1];
                    if(isValid(newx,newy,grid,visited)){
                        queue.offer(List.of(newx,newy));
                    }
                }
            }
            
            distance++;
        }


    }

    private boolean isValid(int x, int y, int[][] grid, boolean [][] visited){
        return x>=0 && y>=0 && x<grid.length && y< grid[0].length && grid[x][y]!=0 && grid[x][y] != -1 && !visited[x][y];
    }


}
