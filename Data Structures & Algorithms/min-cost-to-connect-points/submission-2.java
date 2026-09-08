class Solution {
    public int minCostConnectPoints(int[][] points) {

        if(points.length <=1){
            return 0;
        }

        Map<Integer, List<Pair>> adjList = new HashMap();

        for(int i=0; i<points.length; i++){
            int srcx = points[i][0];
            int srcy = points[i][1];
            List<Integer> x = List.of(srcx,srcy);
            for(int j=i+1; j<points.length; j++){
                
                int destx = points[j][0];
                int desty = points[j][1];
                int distance = Math.abs(srcx-destx)+Math.abs(srcy-desty);
                adjList.computeIfAbsent(i, k-> new ArrayList()).add(new Pair(j, distance));
                adjList.computeIfAbsent(j, k-> new ArrayList()).add(new Pair(i, distance));
            }
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->a.distance-b.distance);
        Set<Integer> visited = new HashSet();

        pq.offer(new Pair(0,0));

        int ans = 0;

        while(!pq.isEmpty()){
            Pair top = pq.poll();
            if(visited.contains(top.index)){
                continue;
            }
            visited.add(top.index);
            ans+=top.distance;

            for(Pair p: adjList.get(top.index)){
                Pair np = new Pair(p.index, p.distance);
                pq.offer(np);
            }
        }

        return ans;
        
    }

    class Pair{
        int index;
        int distance;

        Pair(int index, int dis){
            this.index = index;
            this.distance = dis;
        }
    }
}
 