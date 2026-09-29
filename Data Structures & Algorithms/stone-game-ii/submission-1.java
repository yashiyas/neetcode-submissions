class Solution {
     Map<String,Integer> cache = new HashMap();
    public int stoneGameII(int[] piles) {

        return solve(piles,0,1,true);
        
        
    }

    private int solve(int[] piles, int index, int m, boolean aliceTurn){
        int n = piles.length;
        if(index >= piles.length){
            return 0;
        }

        String key = String.valueOf(index)+"|"+String.valueOf(m)+"|"+String.valueOf(aliceTurn);
        if(cache.containsKey(key)){
            return cache.get(key);
        }

        if(aliceTurn){
            int curr = 0;
            int maxPoints = 0;

            for(int i=1; i<=Math.min(2*m, n-index); i++){
                curr = curr+piles[index+i-1];
                int currPoint = curr+solve(piles, index+i, Math.max(m,i), false);
                maxPoints = Math.max(maxPoints, currPoint);
            }
            cache.put(key, maxPoints);
            return maxPoints;
        }else{
            int maxPoints = Integer.MAX_VALUE;

            for(int i=1; i<=Math.min(2*m, n-index); i++){
                int currPoint = solve(piles, index+i, Math.max(m,i), true);
                maxPoints = Math.min(maxPoints, currPoint);
            }
            cache.put(key, maxPoints);
            return maxPoints;
        }
    }
}