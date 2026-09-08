class Solution {
    public int missingNumber(int[] nums) {

        int res = 0;
        int num = 0;

        for(int i =0; i<nums.length; i++){
            res = (res ^ nums[i]) ^ num;
            num++;
        }

        res = res ^ num;

        return res;
        
    }
}
