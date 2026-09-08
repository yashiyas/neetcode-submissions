class Solution {
    public int minimumSpanningTree(List<List<Integer>> edges, int n) {

        int ans = 0;
        int connected = 0;

        UnionFind uf = new UnionFind(n);

        PriorityQueue<List<Integer>> pq = new PriorityQueue<>(
            (a,b)->a.get(2)-b.get(2)
        );

        for(int i=0; i<edges.size(); i++){
            pq.offer(edges.get(i));
        }

        while(!pq.isEmpty()){
            List<Integer> top = pq.poll();
            int n1 = top.get(0);
            int n2 = top.get(1);
            int weight = top.get(2);

            if(uf.union(n1,n2)){
                ans+=weight;
                connected++;
            }
        }

        if(connected == n-1){
            return ans;
        }

        return -1;

    }


    class UnionFind{
        Map<Integer,Integer> parent;
        Map<Integer,Integer> rank;

        UnionFind(int n){
            this.parent = new HashMap();
            this.rank = new HashMap();

            for(int i=0; i<n; i++){
                parent.put(i,i);
                rank.put(i,0);
            }
        }

        public boolean union(int n1, int n2){
            int p1 = find(n1);
            int p2 = find(n2);
            
            if(p1 == p2){
                return false;
            }

            int r1 = rank.get(p1);
            int r2 = rank.get(p2);

            if(r1 < r2){
                parent.put(p1,p2);
                return true;
            }
            if(r2 < r1){
                parent.put(p2, p1);
                return true;
            }

            parent.put(p2,p1);
            rank.put(p1, r1+1);
            return true;
        }

        public Integer find(int n){
            if(parent.get(n) != n){
                parent.put(n, find(parent.get(n)));
            }
            return parent.get(n);
        }
    }
}
