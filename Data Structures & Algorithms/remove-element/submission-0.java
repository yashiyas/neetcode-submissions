class Solution {
    public int removeElement(int[] nums, int val) {
        int s = nums.length;
        int i=0;
        while(i<s){
            if(nums[i] == val){
                nums[i] = nums[s-1];
                s--;
            }
            else{
                i++;
            }
        }

        return s;
    }
}