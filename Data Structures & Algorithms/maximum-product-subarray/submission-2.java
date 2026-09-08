class Solution {
    public int maxProduct(int[] nums) {
        int currMax = nums[0];
        int currMin = nums[0];
        int res = nums[0];

        for(int i=1; i<nums.length; i++){
            int curr = nums[i];
            int temp = curr*currMax;
            currMax = Math.max(Math.max(temp,curr*currMin),curr);
            currMin = Math.min(Math.min(temp,curr*currMin),curr);
            res = Math.max(res,currMax);
        }

        return res;
        
    }
}
