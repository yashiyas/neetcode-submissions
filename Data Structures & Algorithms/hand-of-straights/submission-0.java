class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {

        int n = hand.length;
        if(n%groupSize != 0){
            return false;
        }

        boolean[] visited = new boolean[n];
        Arrays.sort(hand);

        int groups = n/groupSize;

        Map<Integer,Integer> freqMap = new HashMap();

        for(int i=0; i<n; i++){
            int freq = freqMap.getOrDefault(hand[i],0)+1;
            freqMap.put(hand[i],freq);
        }

        while(groups > 0){

            int minV = findMin(hand,visited, freqMap);
            if(!canCreateGroup(minV,hand,visited,freqMap, groupSize)){
                return false;
            }
            groups--;
        }

        return true;
        
    }

    private Integer findMin(int[] hand, boolean[] visited, Map<Integer,Integer> freqMap){
        int i=0;
        while(visited[i]){
            i++;
        }
        System.out.println(i);
        visited[i] = true;
        int freq = freqMap.get(hand[i]) - 1;
        if(freq == 0){
            freqMap.remove(hand[i]);
        }else{
            freqMap.put(hand[i], freq);
        }
        return hand[i];
    }

    private boolean canCreateGroup(int minV, int[] hand, boolean[] visited, Map<Integer,Integer> freqMap, int grpSize){
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
                updateVisited(nextV,visited,hand);
                currMin = nextV;
                s++;
            }else{
                return false;
            }
        }

        return true;
    }

    private void updateVisited(int value, boolean[] visited, int[] hand){
        for(int i=0; i<hand.length; i++){
            if(hand[i] == value && !visited[i]){
                visited[i] = true;
                break;
            }
        }
    }
}
