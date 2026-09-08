class Solution {
    public int maximumMinimumPath(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int ans = Integer.MIN_VALUE;

        PriorityQueue<Pair> queue = new PriorityQueue();

        queue.offer(new Pair(0,0,grid[0][0]));
        boolean[][] visited = new boolean[m][n];
        visited[0][0] = true;

        int[][] directions = new int[][]{
            {0,1}, {0,-1}, {1,0}, {-1,0}
        };


        while(!queue.isEmpty()){
            Pair top = queue.poll();
            ans = top.score;
            if(top.x == m-1 && top.y == n-1){
                return ans;
            }

            for(int[] dir: directions){
                int newX = top.x + dir[0];
                int newY = top.y + dir[1];

                if(isValid(newX,newY,visited)){
                    int s = Math.min(top.score, grid[newX][newY]);
                    Pair curr = new Pair(newX,newY,s);
                    queue.offer(curr);
                    visited[newX][newY] = true;
                }
            }


        }

        return ans;
        
    }

    private boolean isValid(int x, int y, boolean[][] visited){
        int m = visited.length;
        int n = visited[0].length;

        if(x < 0 || y < 0 || x>=m || y >=n){
            return false;
        }

        return !visited[x][y];
    }

    class Pair implements Comparable<Pair>{
        int x;
        int y;
        int score;

        Pair(int x, int y, int s){
            this.x = x;
            this.y = y;
            this.score = s;
        }

        @Override
        public int compareTo(Pair p2){
            return Integer.compare(p2.score, this.score);
        }
    }
}
