class Solution {
    public int[] getConcatenation(int[] nums) {
        int o = nums.length;
        int s = 2* nums.length;
        int [] ans = new int[s];

        for(int i=0; i<o; i++){
            ans[i]=nums[i];
            ans[i+o] = nums[i];
        }

        return ans;

    }
}