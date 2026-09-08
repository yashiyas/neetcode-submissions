class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        PriorityQueue<Pair> pq = new PriorityQueue<>((a,b)->(a.freq-b.freq));

        Map<Integer,Integer> freqMap = new HashMap();

        for(int i: nums){
            int freq = freqMap.getOrDefault(i,0) + 1;
            freqMap.put(i, freq);
        }

        for(Map.Entry<Integer,Integer> entry: freqMap.entrySet()){
            int num = entry.getKey();
            int freq = entry.getValue();

            if(pq.isEmpty() || pq.size() < k){
                pq.offer(new Pair(num,freq));
            }else if(pq.peek().freq < freq){
                pq.poll();
                pq.offer(new Pair(num,freq));
            }
        }

        int[] ans = new int[k];
        int i=0;

        while(!pq.isEmpty()){
            ans[i] = pq.poll().num;
            i++;
        }

        return ans;
        
    }

    class Pair{
        int num;
        int freq;

        Pair(int n, int f){
            this.num = n;
            this.freq = f;
        }
    }
}
