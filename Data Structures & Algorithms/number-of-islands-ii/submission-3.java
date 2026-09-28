class Solution {
    private static final int[][] directions = new int[][]{
            {-1,0}, {1,0}, {0,-1}, {0,1}
        };


    public List<Integer> numIslands2(int m, int n, int[][] positions) {

        UnionFind uf = new UnionFind(m*n);
        int[][] grid = new int[m][n];
        List<Integer> ans = new ArrayList();

        for(int i=0; i<positions.length; i++){
            int[] pos = positions[i];
            uf.fillLand(pos[0], pos[1], grid);
            ans.add(uf.count);
        }


        return ans;
        
    }

    class UnionFind{

        int[] parent;
        int[] rank;

        int count;

        UnionFind(int size){
            this.parent = new int[size];
            this.rank = new int[size];

            for(int i=0; i<size; i++){
                parent[i] = i;
            }
            this.count = 0;
        }

        private void fillLand(int x, int y, int[][] grid){
            if (grid[x][y] == 1) {
                return;
            }
            int m = grid.length;
            int n = grid[0].length;
            int cord = x*n+y;
            this.count++;

            grid[x][y] = 1;

            for(int i=0; i<4; i++){
                int newX = x+directions[i][0];
                int newY = y+directions[i][1];

                int neigh = n*newX + newY;

                if(isValid(newX,newY, grid) && grid[newX][newY] == 1){
                    union(cord, neigh);
                }
            }


        }

        private void union(int index1, int index2){

            int parent1 = getParent(index1);
            int parent2 = getParent(index2);

            if(parent1 == parent2){
                return;
            }

            int rank1 = this.rank[parent1];
            int rank2 = this.rank[parent2];

            if(rank1 > rank2){
                parent[parent2] = parent1;
                rank[parent1] = rank[parent1]+1;
            }else{
                parent[parent1] = parent2;
                rank[parent2] = rank[parent2]+1;
            }

            this.count = this.count-1;


        }

        private int getParent(int index){
            while(parent[index] != index){
                index = parent[index];
            }

            return index;
        }

        private boolean isValid(int x, int y, int[][] grid){
            if(x < 0 || y<0 || x>=grid.length || y>=grid[0].length){    
                return false;
            }
            return true;
        }

    }
}