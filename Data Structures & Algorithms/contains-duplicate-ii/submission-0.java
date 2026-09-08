class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        
        
        for(int i=0; i<nums.length; i++){
            int limit = Math.min(i+k+1, nums.length);
            for(int j=i+1; j<limit; j++){
                if(nums[i] == nums[j]){
                    return true;
                }
            }
        }
        return false;
    }
}