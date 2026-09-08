class Solution {
    public int maxSubArray(int[] nums) {

        int ans = nums[0];

        int currSum = nums[0];

        for(int i=1; i<nums.length; i++){
            currSum = Math.max(nums[i], currSum+nums[i]);
            if(ans < currSum){
                ans = currSum;
            }
            if(currSum < 0){
                currSum = 0;
            }

        }

        return ans;
        
    }
}
