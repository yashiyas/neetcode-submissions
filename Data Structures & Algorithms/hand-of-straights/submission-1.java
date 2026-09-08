class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {

        int n = hand.length;
        if(n%groupSize != 0){
            return false;
        }

        int groups = n/groupSize;

        Map<Integer,Integer> freqMap = new HashMap();

        for(int i=0; i<n; i++){
            int freq = freqMap.getOrDefault(hand[i],0)+1;
            freqMap.put(hand[i],freq);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(Map.Entry<Integer,Integer> entry: freqMap.entrySet()){
            pq.offer(entry.getKey());
        }

        while(groups > 0){
            int minV = findMin(hand,pq,freqMap);
            if(!canCreateGroup(minV,hand,freqMap, groupSize)){
                return false;
            }
            groups--;
        }

        return true;
        
    }

    private Integer findMin(int[] hand, PriorityQueue<Integer> pq, Map<Integer,Integer> freqMap){

        while(true){
            Integer val = pq.poll();
            if(freqMap.containsKey(val)){
                int freq = freqMap.get(val) - 1;
                if(freq == 0){
                    freqMap.remove(val);
                    return val;
                }else{
                    freqMap.put(val, freq);
                    pq.offer(val);
                    return val;
                }
            }
        }
        
    }

    private boolean canCreateGroup(int minV, int[] hand, Map<Integer,Integer> freqMap, int grpSize){
        int s = 1;
        int currMin = minV;
        while(s < grpSize){
            int nextV = currMin+1;
            if(freqMap.containsKey(nextV)){
                int freq = freqMap.get(nextV) - 1;
                if(freq == 0){
                    freqMap.remove(nextV);
                }
                else{
                    freqMap.put(nextV, freq);
                }
                currMin = nextV;
                s++;
            }else{
                return false;
            }
        }

        return true;
    }

    class Pair{
        int val;
        int freq;

        Pair(int v, int f){
            this.val = v;
            this.freq = f;
        }
    }
}
