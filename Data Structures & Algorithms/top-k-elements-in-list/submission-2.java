class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->a[1] - b[1]);

        Map<Integer, Integer> freqMap = new HashMap();

        for(int i=0; i<nums.length; i++){
            freqMap.computeIfAbsent(nums[i],x->0);
            freqMap.put(nums[i], freqMap.get(nums[i]) + 1);
        }

        for(Map.Entry<Integer,Integer> entry: freqMap.entrySet()){
            int element = entry.getKey();
            int freq = entry.getValue();
            int[] curr = new int[]{
                element, freq
            };

            if(pq.size() < k){
                pq.offer(curr);
            }else{
                int[] top = pq.peek();
                if(top[1] < curr[1]){
                    pq.poll();
                    pq.offer(curr);
                }
            }
        }

        int[] ans = new int[k];
        int i = 0;
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            ans[i] = curr[0];
            i++;
        }

        return ans;
    }
}
