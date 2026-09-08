class Solution {
    public int[][] kClosest(int[][] points, int k) {

        PriorityQueue<Pair> pq = new PriorityQueue();

        for(int i=0; i<points.length; i++){
            int x = points[i][0];
            int y = points[i][1];
            int dis = x*x+y*y;

            pq.offer(new Pair(points[i], dis));
        }

        while(pq.size() > k){
            pq.poll();
        }

        int s = pq.size();

        int[][] ans = new int[s][2];
        int i=0;
        while(!pq.isEmpty()){
            Pair top = pq.poll();
            int [] point = new int[2];
            point[0] = top.point[0];
            point[1] = top.point[1];
            ans[i] = point;
            i++;
        
        }

    return ans;
        

    }

    class Pair implements Comparable<Pair> {
        int[] point;
        int distance;

        @Override
        public int compareTo(Pair p2){
            return p2.distance - this.distance;
        }

        Pair(int[] point, int distance){
            this.point = point;
            this.distance = distance;
        }
    }
}
