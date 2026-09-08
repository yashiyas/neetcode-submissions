class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        
        int ans=0;
        int sum = 0;
        for(int i: nums){
            if(i == 0){
                if(sum > ans){
                    ans = sum;
                }
                sum = 0;
            }
            else{
                sum+=1;
            }
        }
        if(sum > ans){
            ans = sum;
        }
        return ans;
    }
}