class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {

        int q = queries.length;

        int[] sortedQueries = new int[q];

        for(int i=0; i<queries.length; i++){
            sortedQueries[i] = queries[i];
        }

        Arrays.sort(sortedQueries);

        Arrays.sort(intervals, (a,b)->a[0]-b[0]);

        Map<Integer,Integer> queryLen = new HashMap();

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)-> {
            if(a.len != b.len){
                return a.len - b.len;
            }
            return a.index - b.index;
        });

        int i=0;
        int j=0;

        while(i<q){
            while(j<intervals.length && intervals[j][0] <= sortedQueries[i]){
                Pair p = new Pair((intervals[j][1]-intervals[j][0]+1), intervals[j][1]);
                pq.offer(p);
                j++;
            }

            while(!pq.isEmpty() && pq.peek().index < sortedQueries[i]){
                pq.poll();
            }

            if(pq.isEmpty()){
                queryLen.put(sortedQueries[i], -1);
            }else{
                queryLen.put(sortedQueries[i], pq.peek().len);
            }
            i++;

        }

        int [] ans = new int[queries.length];

        for(int k=0; k<queries.length; k++){
            ans[k] = queryLen.get(queries[k]);
        }

        return ans;
        
    }

    class Pair{
        Integer len;
        Integer index;

        Pair(Integer len, Integer index){
            this.len = len;
            this.index = index;
        }
    }
}