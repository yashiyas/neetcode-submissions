class Solution {
    public boolean validTree(int n, int[][] edges) {

        UnionFind uf = new UnionFind(n);

        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];

            if(!uf.union(u,v)){
                return false;
            }
        }

        return uf.sets==1;

    }

    class UnionFind{
        int[] parent;
        int[] rank;
        int sets;

        UnionFind(int n){
            this.parent = new int[n];
            this.rank = new int[n];
            this.sets = n;

            for(int i=0; i<n; i++){
                parent[i] = i;
            }
        }

        public boolean union(int n1, int n2){
            
            int p1 = getParent(n1);
            int p2 = getParent(n2);

            if(p1 == p2){
                return false;
            }

            int r1 = this.rank[p1];
            int r2 = this.rank[p2];

            if(r1 > r2){
                parent[p2] = p1;
            }else if(r2 > r1){
                parent[p1] = p2;
            }else{
                parent[p2] = p1;
                rank[p1] = r1+1;
            }

            this.sets--;
            return true;


        }

        private int getParent(int node){
            if(node != parent[node]){
                parent[node] = getParent(parent[node]);
            }

            return parent[node];
        }
    }
}
