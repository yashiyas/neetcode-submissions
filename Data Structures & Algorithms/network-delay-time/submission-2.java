class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        Map<Integer, List<Network>> adjList = new HashMap();

        for(int i=1; i<=n; i++){
            adjList.put(i, new ArrayList());
        }

        for(int[] time: times){
            int u = time[0];
            int v = time[1];
            int d = time[2];

            adjList.get(u).add(new Network(v,d));
        }

        Set<Integer> reached = new HashSet();
        reached.add(k);

        PriorityQueue<Network> pq = new PriorityQueue<>((a,b) -> a.delay - b.delay);

        for(int i=0; i<adjList.get(k).size(); i++){
            pq.offer(adjList.get(k).get(i));
        }

        int ans = -1;

        while(!pq.isEmpty() && reached.size() < n){

            Network network = pq.poll();
            int node = network.node;
            if(reached.contains(node)){
                continue;
            }

            reached.add(node);

            ans = network.delay;

            for(int i=0; i<adjList.get(node).size(); i++){
                int neigh = adjList.get(node).get(i).node;
                int currDelay = adjList.get(node).get(i).delay + ans;

                Network currNet = new Network(neigh, currDelay);
                pq.offer(currNet);
            }



        }

        if(reached.size() < n){
            return -1;
        }

        return ans;



        
    }

    class Network{
        int node;
        int delay;

        Network(int node, int delay){
            this.node = node;
            this.delay = delay;
        }
    }
}
