class Solution {
    public int lastStoneWeight(int[] stones) {

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)-> b - a);

        for(int i=0; i<stones.length; i++){
            pq.offer(stones[i]);
        }

        while(pq.size() > 1){
            int p1 = pq.poll();
            int p2 = pq.poll();
            int rem = p1-p2;
            if(rem != 0){
                pq.offer(rem);
            }
        }

        if(pq.size() == 0){
            return 0;
        }

        return pq.poll();
        
    }
}
