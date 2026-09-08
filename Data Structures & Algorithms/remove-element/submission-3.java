class Solution {
    public int removeElement(int[] nums, int val) {
        int s = nums.length;
        if( s == 0){
            return 0;
        }
        if(s < 2){
            if(nums[0] == val){
                return 0;
            }
            return 1;
        }
        int i=0;
        int j = 1;
        int ans=0;
        while(i<s){
            if(nums[i] == val){
                while(j<nums.length && nums[j] == val ){
                    j++;
                }
                if(j>=s){
                    return ans;
                }
                int k = nums[i];
                nums[i]= nums[j];
                nums[j] = k;
                i++;
                ans++;

            }
            else{
                i++;
                j++;
                ans++;
            }
        }

        return ans;
    }
}