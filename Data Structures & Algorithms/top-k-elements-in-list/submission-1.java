class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> freq = new HashMap();
        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b) -> b.freq - a.freq);

        for(int i: nums){
           int f = freq.getOrDefault(i,0) +1;
           freq.put(i,f);
        }

        for(Map.Entry<Integer,Integer> entry: freq.entrySet()){
            Pair p = new Pair(entry.getKey(), entry.getValue());
            pq.add(p);
        }

        int [] ans = new int[k];
        int i=0;

        while(i<k && !pq.isEmpty()){
            Pair p = pq.poll();
            ans[i] = p.num;
            i++;
        }

        return ans;

    }

    class Pair{
        int num;
        int freq;

        Pair(int num, int freq){
            this.num = num;
            this.freq = freq;
        }
    }


}
