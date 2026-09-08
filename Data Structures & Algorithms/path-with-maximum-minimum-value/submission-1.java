class Solution {
    public int maximumMinimumPath(int[][] grid) {

        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[0]-a[0]);

        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];

        int[] curr = new int[]{
            grid[0][0], 0, 0
        };

        visited[0][0] = true;

        pq.offer(curr);

        int[][] directions = new int[][]{
            {1,0}, {-1,0}, {0,1}, {0,-1}
        };

        while(!pq.isEmpty()){
            int[] top = pq.poll();
            
            if(top[1] == m-1 && top[2] == n-1){
                return top[0];
            }

            for(int[] dir: directions){
                
                int newX = top[1]+dir[0];
                int newY = top[2]+dir[1];

                if(newX >=0 && newY >=0 && newX < m && newY < n && !visited[newX][newY]){
                    visited[newX][newY] = true;
                    int[] currElement = new int[3];
                    currElement[0] = Math.min(top[0], grid[newX][newY]);
                    currElement[1] = newX;
                    currElement[2] = newY;

                    pq.offer(currElement);

                }
            }



        }

        return -1;
        
    }

}