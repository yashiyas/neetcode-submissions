class Solution {
    public int longestIncreasingPath(int[][] matrix) {

        int n = matrix.length;
        int m = matrix[0].length;
        boolean[][] visited = new boolean[n][m];

        Map<String, Integer> cache = new HashMap();

        int ans = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                ans = Math.max(ans, 1+solve(matrix,visited,i,j,cache));
            }
        }

        return ans;
        
    }

    private int solve(int[][] matrix, boolean[][] visited, int i, int j, Map<String, Integer> cache){
        String key = String.valueOf(i)+"|"+String.valueOf(j);

        if(cache.containsKey(key)){
            return cache.get(key);
        }

        if(visited[i][j]){
            return 0;
        }

        visited[i][j] = true;

        int[][] direction = new int[][]{
            {1,0}, {-1,0}, {0,1}, {0,-1}
        };

        int ans = 0;

        for(int[] dir: direction){
            int newX = i+dir[0];
            int newY = j+dir[1];

            if(isValid(newX,newY,visited) && matrix[i][j] < matrix[newX][newY]){
                ans = Math.max(ans, 1+solve(matrix,visited,newX,newY,cache));
            }
        }
        visited[i][j] = false;
        cache.put(key,ans);
        return ans;
    }

    private boolean isValid(int x, int y, boolean[][] visited){
        int n = visited.length;
        int m = visited[0].length;

        if(x<0 || y<0 || x>=n || y>=m){
            return false;
        }

        return !visited[x][y];
    }
}