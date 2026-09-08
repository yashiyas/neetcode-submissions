class Solution {
    public int[] findRedundantConnection(int[][] edges) {

        int n = edges.length;
        UnionFind uf = new UnionFind(n);

        for(int i=0; i<n; i++){
            int n1 = edges[i][0];
            int n2 = edges[i][1];

            if(!uf.union(n1,n2)){
                return edges[i];
            }
        }

        return new int[2];


        
    }

    class UnionFind{
        private Map<Integer, Integer> parent;
        private Map<Integer, Integer> ranks;

        public UnionFind(int n){
            this.parent = new HashMap();
            this.ranks = new HashMap();

            for(int i=1; i<=n; i++){
                this.parent.put(i,i);
                this.ranks.put(i,0);
            }
        }


        public int find(int node){
            if(this.parent.get(node) != node){
                this.parent.put(node, find(this.parent.get(node)));
            }

            return this.parent.get(node);
        }

        public boolean union(int n1, int n2){
            int p1 = find(n1);
            int p2 = find(n2);

            if(p1 == p2){
                return false;
            }

            int r1 = this.ranks.get(p1);
            int r2 = this.ranks.get(p2);

            if( r1 < r2){
                this.parent.put(p1,p2);
            }else if(r1 > r2){
                this.parent.put(p2,p1);
            }else{
                this.parent.put(p2,p1);
                this.ranks.put(p1, r1+1);
            }

            return true;
        }
    }
}
