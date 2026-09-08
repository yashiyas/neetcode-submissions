class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        Set<Integer> visited = new HashSet();
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.time - b.time);

        Map<Integer, List<Pair>> adjList = new HashMap();
        for(int i=1; i<=n; i++){
            adjList.put(i,new ArrayList());
        }

        for(int i=0; i<times.length; i++){
            int src = times[i][0];
            int dest = times[i][1];
            int time = times[i][2];

            Pair p = new Pair(dest,time);
            adjList.get(src).add(p);
        }

        int ans = Integer.MIN_VALUE;
        int currDist = 0;

        visited.add(k);

        for(Pair p:adjList.get(k)){
            pq.offer(p);
        }

        while(!pq.isEmpty()){
            Pair top = pq.poll();
            if(visited.contains(top.node)){
                continue;
            }
            visited.add(top.node);
            if(ans < top.time){
                ans = top.time;
            }
            for(Pair p:adjList.get(top.node)){
                p.time = p.time+top.time;
                pq.offer(p);
            }

        }

        if(visited.size() < n){
            return -1;
        }

        return ans;


    }

    class Pair{
        int node;
        int time;

        Pair(int node, int time){
            this.node = node;
            this.time = time;
        }
    }
}
