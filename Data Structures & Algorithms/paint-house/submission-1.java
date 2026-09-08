class Solution {
    public int minCost(int[][] costs) {

        Map<String, Integer> cache = new HashMap();

        int a = costs[0][0] + costReq(costs,1,0,cache);
        int b = costs[0][1] + costReq(costs,1,1,cache);
        int c = costs[0][2] + costReq(costs,1,2,cache);

        return Math.min(a, Math.min(b,c));

        
    }

    private int costReq(int[][] costs, int house, int prevCol, Map<String, Integer> cache){

        if(house >= costs.length){
            return 0;
        }

        String key = String.valueOf(house) + "|" + String.valueOf(prevCol);

        if(cache.containsKey(key)){
            return cache.get(key);
        }

        int currMin = Integer.MAX_VALUE;

        for(int i=0; i<3; i++){
            if(i==prevCol){
                continue;
            }

            int curr = costs[house][i] + costReq(costs,house+1,i,cache);
            if(curr < currMin){
                currMin = curr;
            }

        }

        cache.put(key,currMin);
        return currMin;

    }
}