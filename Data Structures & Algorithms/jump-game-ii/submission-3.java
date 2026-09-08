class Solution {
    public int jump(int[] nums) {

        if(nums.length <=1){
            return 0;
        }

        int maxJump=0;
        int l=0;
        int r=0;
        int ans=0;

        while(r<nums.length-1){
            for(int j=l; j<r+1; j++){
                int currJump = j+nums[j];
                if(maxJump < currJump){
                    maxJump = currJump;
                }
            }
            ans++;
            l = r+1;
            r = maxJump;
            maxJump = 0;
        }

        return ans;
        
    }
}
