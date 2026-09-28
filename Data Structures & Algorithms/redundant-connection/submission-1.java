class Solution {
    public int[] findRedundantConnection(int[][] edges) {

        int n = edges.length;

        UnionFind uf = new UnionFind(n);

        for(int[] edge: edges){
            if(!uf.union(edge[0], edge[1])){
                return edge;
            }
        }

        return new int[2];
        
    }

    class UnionFind{
        int[] parent;
        int[] rank;

        UnionFind(int n){
            this.parent = new int[n+1];
            this.rank = new int[n+1];

            for(int i=0; i<=n; i++){
                parent[i] = i;
            }
        }


        private boolean union(int n1, int n2){
            int p1 = getParent(n1);
            int p2 = getParent(n2);

            if(p1 == p2){
                return false;
            }

            int r1 = rank[p1];
            int r2 = rank[p2];

            if(r1 > r2){
                parent[p2] = p1;
            }else if(r2 > r1){
                parent[p1] = p2;
            }else{
                parent[p2] = p1;
                rank[p1] = r1+1;
            }

            return true;
        }

        private int getParent(int n1){
            if(n1 != parent[n1]){
                parent[n1] = getParent(parent[n1]);
            }
            return parent[n1];
        }
    }
}
