class Solution {
    public boolean stoneGame(int[] piles) {

        int aliceSum = 0;
        boolean turn = true;

        int start = 0;
        int end = piles.length-1;

        int tsum = 0;
        for(int i:piles){
            tsum+=i;
        }

        Map<String,Boolean> cache = new HashMap();

        return solve(piles,0,end,true,piles[0],tsum,cache);
        
    }

    private boolean solve(int[] piles, int start, int end, boolean turn, int aliceSum, int tsum, Map<String,Boolean> cache){

        String key = String.valueOf(start)+"|"+String.valueOf(end)+"|"+String.valueOf(turn);
        if(cache.containsKey(key)){
            return cache.get(key);
        }
        if(start == end){
            int bobSum = tsum-aliceSum;
            return aliceSum > bobSum;
        }


        if(!turn){
            boolean ans = solve(piles,start+1,end,true,aliceSum,tsum,cache) || solve(piles,start,end-1,true,aliceSum,tsum,cache);
            cache.put(key,ans);
            return ans;
        }
        else{
            boolean ans = solve(piles,start+1,end,false,aliceSum+piles[start],tsum,cache) || solve(piles,start,end-1,false,aliceSum+piles[end],tsum,cache);
            cache.put(key,ans);
            return ans;
        }
    }

}