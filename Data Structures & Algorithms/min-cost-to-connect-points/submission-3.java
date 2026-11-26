class Solution {
    public int minCostConnectPoints(int[][] points) {

        PriorityQueue<Point> pq = new PriorityQueue<>((a,b)->a.dist-b.dist);

        Map<Integer, List<Point>> adjList = new HashMap();

        for(int i=0; i<points.length; i++){
            adjList.put(i, new ArrayList());
        }

        int ans = 0;

        for(int i=0; i<points.length; i++){
            int x = points[i][0];
            int y = points[i][1];

            for(int j=i+1; j<points.length; j++){
                int x2 = points[j][0];
                int y2 = points[j][1];

                int dist = Math.abs(x-x2) + Math.abs(y-y2);

                adjList.get(i).add(new Point(j, dist));
                adjList.get(j).add(new Point(i, dist));
            }
        }

        pq.offer(new Point(0,0));

        int connected = 0;
        Set<Integer> visited = new HashSet();

        while(connected < points.length && !pq.isEmpty()){
            Point point = pq.poll();

            if(visited.contains(point.index)){
                continue;
            }

            visited.add(point.index);
            connected++;
            ans+=point.dist;

            List<Point> pointsList = adjList.get(point.index);

            for(Point currPoint: pointsList){
                pq.offer(currPoint);
            }
        }

        return ans;





        
    }

    class Point{
        int index;
        int dist;

        Point(int index, int dist){
            this.index = index;
            this.dist = dist;
        }

    }
}
