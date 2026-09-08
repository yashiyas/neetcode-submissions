class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        Map<Integer, List<Pair>> adjList = new HashMap();
        for(int i=0; i<n; i++){
            adjList.put(i, new ArrayList());
        }

        for(int i=0; i<flights.length; i++){
            int s = flights[i][0];
            int d = flights[i][1];
            int c = flights[i][2];

            adjList.get(s).add(new Pair(d, c));
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> a.cost - b.cost);
        int stops = 1;
        for(Pair p: adjList.get(src)){
            p.stops = stops;
            pq.offer(p);
        }

        while(!pq.isEmpty()){
            Pair top = pq.poll();
            if(top.stops > k+1){
                continue;
            }
            if (top.dest == dst){
                return top.cost;
            }

            for(Pair pair: adjList.get(top.dest)){
                Pair newP = new Pair(pair.dest, pair.cost+top.cost);
                newP.stops = top.stops+1;
                pq.offer(newP);
            }
        }

        return -1;

    }

    class Pair{
        int dest;
        int cost;
        int stops;

        Pair(int dest, int cost){
            this.dest = dest;
            this.cost = cost;
            this.stops = 0;
        }
    }
}
