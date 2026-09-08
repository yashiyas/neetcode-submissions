class Solution {
    public int findTargetSumWays(int[] nums, int target) {

        List<Integer> curr = new ArrayList();
        
        return solve(nums,target,0,0);
        
    }

    private int solve(int[] nums, int target, int index, int currSum){
        if(index == nums.length){
            if(target == currSum){
                return 1;
            }
            return 0;
        }
        int curr = nums[index];
        return solve(nums,target,index+1,currSum+curr) + solve(nums,target,index+1,currSum-curr);
    
    }
}
