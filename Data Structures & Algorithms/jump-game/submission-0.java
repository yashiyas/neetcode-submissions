class Solution {
    public boolean canJump(int[] nums) {

        if(nums.length <=1){
            return true;
        }

        int goal=nums.length-1;

        for(int i = nums.length-2; i>=0; i--){
            if(canReachGoal(nums, i, goal)){
                goal = i;
            }
        }

        return (goal == 0);
        
    }

    private boolean canReachGoal(int[] nums, int index, int goal){
        return (nums[index] >= (goal - index));
    }
}
