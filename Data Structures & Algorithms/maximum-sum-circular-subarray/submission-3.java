class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int ck = circularKadane(nums);
        int kd = kadane(nums);
        return (ck > kd)? ck: kd;
    }

    private int circularKadane(int[] nums){
        int minSum = Integer.MAX_VALUE;
        int currSum = 0;
        int globalSum = 0;
        int globalMax = Integer.MIN_VALUE;

        for(int i=0; i<nums.length; i++){
            currSum+=nums[i];
            if(minSum > currSum){
                minSum = currSum;
            }
            if(currSum >0){
                currSum = 0;
            }
            globalSum+=nums[i];
            globalMax = Math.max(globalMax, nums[i]);
        }



        int ans = globalSum - minSum;
        if(globalMax < 0){
            return globalMax;
        }
        return (globalMax > ans) ? globalMax : ans;
    
    }

    private int kadane(int [] nums){
        int currSum = 0;
        int ans = Integer.MIN_VALUE;

        for(int i=0; i<nums.length; i++){
            currSum+=nums[i];
            if(ans < currSum){
                ans=currSum;
            }
            if(currSum < 0){
                currSum = 0;
            }
        }

        return ans;
    }
}