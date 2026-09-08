class Solution {
    public int uniquePaths(int m, int n) {

        if(m==1 && n==1){
            return 1;
        }

        int[][] cache = new int[m][n];
        cache[m-1][n-1] = 1;

    
        return fill(0,1,cache,m,n) + fill(1,0,cache,m,n);
        
    }

    private int fill(int r, int c, int[][] cache, int m, int n){
        if(r==m || c == n){
            return 0;
        }

        if(r==m-1 && c== n-1){
            return 1;
        }

        if(cache[r][c] != 0){
            return cache[r][c];
        }

        int t =  fill(r+1,c,cache,m,n) + fill(r,c+1,cache,m,n);
        cache[r][c] = t;
        return t;



    }
}
