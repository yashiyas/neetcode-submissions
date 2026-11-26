class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        Map<Integer, List<int[]>> adjList = new HashMap();

        for(int i=1; i<=n; i++){
            adjList.put(i, new ArrayList());
        }

        for(int i=0; i<times.length; i++){
            int start = times[i][0];
            int end = times[i][1];
            int time = times[i][2];

            adjList.get(start).add(new int[]{end,time});
        }

        int ans = 0;
        Set<Integer> visited = new HashSet();

        PriorityQueue<Network> queue = new PriorityQueue();
        queue.offer(new Network(k,0));
        

        while(!queue.isEmpty() && visited.size() < n){
            Network network = queue.poll();
            if(visited.contains(network.node)){
                 continue;
            }

            ans = Math.max(network.time, ans);
            visited.add(network.node);
            
            List<int[]> neigh = adjList.get(network.node);
            for(int i=0; i<neigh.size(); i++){
                int[] curr = neigh.get(i);
                if(!visited.contains(curr[0])){
                    queue.offer(new Network(curr[0], curr[1]+network.time));
                }
            }
        }

        if(visited.size() == n){
            return ans;
        }

        return -1;
        
    }

    class Network implements Comparable<Network>{
        int node;
        int time;

        Network(int node, int time){
            this.node = node;
            this.time = time;
        }

        @Override
        public int compareTo(Network network){
            return Integer.compare(this.time, network.time);
        }
    }
}
