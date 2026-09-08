class Solution {
    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {

        Map<Integer, List<Pair>> adjList = new HashMap();

        for(int i=0; i<n; i++){
            adjList.put(i, new ArrayList());
        }

        for(int i=0; i<edges.length; i++){
            int src = edges[i][0];
            int dest = edges[i][1];
            double prob = succProb[i];

            Pair pd = new Pair(dest, prob);
            Pair ps = new Pair(src, prob);
            adjList.get(src).add(pd);
            adjList.get(dest).add(ps);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> Double.compare(b.prob, a.prob));

        pq.offer(new Pair(start_node,1.0));

        Set<Integer> visited = new HashSet();

        while(!pq.isEmpty()){
            Pair top = pq.poll();
            if(top.node == end_node){
                return top.prob;
            }

            if(visited.contains(top.node)){
                continue;
            }

            visited.add(top.node);

            for(Pair p: adjList.get(top.node)){
                Pair np = new Pair(p.node, top.prob*p.prob);
                pq.offer(np);
            }
        }

        return 0;
        
    }

    class Pair {
        int node;
        double prob;

        Pair(int n, double p){
            this.node = n;
            this.prob = p;
        }
    }
}