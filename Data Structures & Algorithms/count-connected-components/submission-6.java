class Solution {
    public int countComponents(int n, int[][] edges) {

        UnionFind uf = new UnionFind(n);

        for(int[] edge: edges){
            int u = edge[0];
            int v = edge[1];

            uf.union(u,v);
        }

        return uf.connected;

    }

    class UnionFind{
        int[] parent;
        int[] rank;
        int connected;

        UnionFind(int n){
            this.parent = new int[n];
            this.rank = new int[n];
            this.connected = n;

            for(int i=0; i<n; i++){
                parent[i] = i;
            }
        }

        private void union(int n1, int n2){
            int p1 = getParent(n1);
            int p2 = getParent(n2);

            if(p1 == p2){
                return;
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

            this.connected = this.connected-1;

        }

        private int getParent(int n1){
            if(n1 != parent[n1]){
                parent[n1] = getParent(parent[n1]);
            }

            return parent[n1];
        }


    }
}