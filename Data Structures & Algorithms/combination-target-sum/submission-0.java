class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList();
        List<Integer> curr = new ArrayList();
        int currSum = 0;
        backtrack(ans,curr,0,target,nums,0);
        return ans;
        
    }

    private void backtrack(List<List<Integer>> ans, List<Integer> curr, int currSum, int target, int[] nums, int i){
        if(currSum == target){
            List<Integer> temp = new ArrayList(curr);
            ans.add(temp);
            return;
        }
        if(currSum > target){
            return;
        }
        for(int k=i; k<nums.length; k++){
            curr.add(nums[k]);
            currSum+=nums[k];
            backtrack(ans,curr,currSum,target,nums,k);
            curr.remove(curr.size()-1);
            currSum-=nums[k];
        }
    }
}
