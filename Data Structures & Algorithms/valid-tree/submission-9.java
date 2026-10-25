class Solution {
    public boolean validTree(int n, int[][] edges) {

        UnionFind uf = new UnionFind(n);

        for(int[] edge: edges){
            int v1 = edge[0];
            int v2 = edge[1];

            if(!uf.union(v1,v2)){
                return false;
            }

        }

        return uf.connected == 1;


    }

    /*
    valid tree
    1. All connected
    2. no cycle
    */

    class UnionFind{
        Map<Integer,Integer> parent;
        Map<Integer,Integer> rank;
        int connected;

        UnionFind(int n){
            this.parent = new HashMap();
            this.rank = new HashMap();
            this.connected = n;

            for(int i=0; i<n; i++){
                parent.put(i,i);
                rank.put(i,0);
            }
        }

        public boolean union(int v1, int v2){
            int p1 = getParent(v1);
            int p2 = getParent(v2);

            if(p1 == p2){
                return false;
            }

            int r1 = rank.get(p1);
            int r2 = rank.get(p2);

            if(r1 < r2){
                parent.put(p1,p2);
            }else if (r2 < r1){
                parent.put(p2,p1);
            }else{
                parent.put(p1,p2);
                rank.put(p2, r2+1);
            }

            connected--;
            return true;
        }

        public int getParent(int v){

            if(v != parent.get(v)){
                parent.put(v, getParent(parent.get(v)));
            }

            return parent.get(v);
        }


    }
}
