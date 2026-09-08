class Solution {
    public int search(int[] nums, int target) {
    

        int r=0;
        int l=nums.length - 1;

        while(r<=l){
            int mid = (r+l)/2;

            if(nums[mid] == target){
                return mid;
            }

            if(nums[mid] < target){
                r=mid+1;
            }
            else{
                l=mid-1;
            }

        }

        return -1;
    }
}
