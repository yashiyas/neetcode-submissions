class Solution {
    public int countComponents(int n, int[][] edges) {

        UnionFind uf = new UnionFind(n);

        for(int i=0; i<edges.length; i++){
            int n1 = edges[i][0];
            int n2 = edges[i][1];

            uf.union(n1,n2);
        }

        Set<Integer> parents = new HashSet();

        for(int i=0; i<n; i++){
            parents.add(uf.find(i));
        }

        return parents.size();

    }


    class UnionFind{
        private Map<Integer,Integer> parent;
        private Map<Integer,Integer> rank;

        public UnionFind(int n){
            this.parent = new HashMap();
            this.rank = new HashMap();

            for(int i=0; i<n; i++){
                this.parent.put(i,i);
                this.rank.put(i,0);
            }
        }

        public int find(int node){
            if(this.parent.get(node) != node){
                this.parent.put(node, find(this.parent.get(node)));
            }
            return this.parent.get(node);
        }

        public boolean union(int node1, int node2){
        
            int p1 = find(node1);
            int p2 = find(node2);

            if(p1 == p2){
                return false;
            }

            int r1 = this.rank.get(p1);
            int r2 = this.rank.get(p2);

            if(r1 < r2){
                this.parent.put(p1,p2);
            }else if(r1 > r2){
                this.parent.put(p2, p1);
            }else{
                this.parent.put(p2, p1);
                this.rank.put(p1, r1+1);
            }

            return true;
        }
    }
}
