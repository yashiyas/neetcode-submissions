class Solution {
    public int earliestAcq(int[][] logs, int n) {

        Arrays.sort(logs, ((a,b)->a[0]-b[0]));

        UnionFind uf = new UnionFind(n);

        for(int[] log: logs){

            int n1 = log[1];
            int n2 = log[2];

            uf.union(n1,n2);

            if(uf.count == n-1){
                return log[0];
            }

        }

        return -1;

        
    }

    class UnionFind{
        int[] parent;
        int[] rank;
        int count;

        UnionFind(int n){
            this.parent = new int[n];
            this.rank = new int[n];
            this.count = 0;

            for(int i=0; i<n; i++){
                parent[i] = i;
            }
        }


        public void union(int n1, int n2){
            int p1 = getParent(n1);
            int p2 = getParent(n2);

            if(p1 == p2){
                return;
            }

            this.count++;

            int r1 = this.rank[p1];
            int r2 = this.rank[p2];

            if(r1 > r2){
                this.parent[p2] = p1;
            }else if(r2 > r1){
                this.parent[p1] = p2;
            }else{
                this.parent[p2] = p1;
                this.rank[p1] = r1+1;
            }


        }

        private int getParent(int node){
            if(this.parent[node] != node){
                int p1 = this.parent[node];
                this.parent[node] = getParent(p1);
            }

            return this.parent[node];
        }
    }
}
