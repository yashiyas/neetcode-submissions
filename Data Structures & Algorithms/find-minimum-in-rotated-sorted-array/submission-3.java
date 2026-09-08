class Solution {
    public int findMin(int[] nums) {

        int n = nums.length;

        if(nums[0] < nums[n-1]){
            return nums[0];
        }

        int l = 0;
        int r = n-1;

        while(l<=r){
            if(nums[l] <= nums[r]){
                return nums[l];
            }

            int mid = (r-l)/2 + l;

            if(nums[mid] >= nums[l]){
                // left part is sorted in increasing order

                l = mid+1;
            }else{
                r = mid;
            }
        }

        return -1;
        
    }
}
