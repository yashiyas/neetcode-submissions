class Solution {
    public int findDuplicate(int[] nums) {
        int s = nums[0];
        int f = nums[0];

        while(true){
            s=nums[s];
            f=nums[nums[f]];
            if(s==f){
                break;
            }
        }

        int s1=nums[0];

        while(s!=s1){
            s=nums[s];
            s1=nums[s1];
        }

        return s;
    }
}
