class Solution {
    public int findTargetSumWays(int[] nums, int target) {

        List<Integer> curr = new ArrayList();
        HashMap<String,Integer> cache = new HashMap();
        
        return solve(nums,target,0,0,cache);
        
    }

    private int solve(int[] nums, int target, int index, int currSum, HashMap<String,Integer> cache){
        if(index == nums.length){
            if(target == currSum){
                return 1;
            }
            return 0;
        }
        int curr = nums[index];
        String key = String.valueOf(index)+String.valueOf(currSum);
        if(cache.containsKey(key)){
            return cache.get(key);
        }
        int ways = solve(nums,target,index+1,currSum+curr,cache) + solve(nums,target,index+1,currSum-curr,cache);
        cache.put(key,ways);
        return ways;
    
    }
}
