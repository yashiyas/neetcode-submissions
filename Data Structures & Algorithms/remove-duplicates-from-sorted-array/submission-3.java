class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length <=1){
            return nums.length;
        }
        int currMax = nums[0];
        int ans = 1;
        int j = 1;
        int i=0;
        while(j < nums.length){
            if(nums[j] > currMax){
                currMax = nums[j];
                j++;
                ans++;
            }
            else{
                while(j < nums.length && nums [j] <= currMax){
                    j++;
                }
                if(j>=nums.length){
                    return ans;
                }
                int k = nums[ans];
                currMax = nums[j];
                nums[ans] = nums[j];
                nums[j] = k;
                ans++;
            }
        }
        return ans;
    }
}