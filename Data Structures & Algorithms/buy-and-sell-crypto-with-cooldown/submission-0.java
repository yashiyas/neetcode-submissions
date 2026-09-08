class Solution {
    public int maxProfit(int[] prices) {

        Map<String,Integer> cache = new HashMap();

        return Math.max(solve(prices,1,false,cache), (-1*prices[0]+solve(prices,1,true,cache)));
        
    }

    private int solve(int[] prices, int index, boolean bought, Map<String,Integer> cache){
        if(index >= prices.length){
            return 0;
        }

        String key = String.valueOf(bought)+"|"+String.valueOf(index);
        if(cache.containsKey(key)){
            return cache.get(key);
        }

        int ans = 0;

        if(bought){
            ans = Math.max((prices[index]+solve(prices,index+2,false,cache)), solve(prices,index+1,true,cache));
        }
        else{
            ans = Math.max(((-1*prices[index])+solve(prices,index+1,true,cache)), solve(prices,index+1,false,cache));
        }

        cache.put(key,ans);
        return ans;
    }
}
