class Solution {
    public int search(int[] nums, int target) {

        int n = nums.length;

        int l = 0;
        int r = n-1;

        while( l <=r && l>=0 && r< n){

            int mid = (r-l)/2 + l;

            if(nums[mid] == target){
                return mid;
            }

            // left sorted
            if(nums[mid] >= nums[l]){
                if(nums[mid] > target && nums[l] <= target){
                    r = mid-1;
                }
                else{
                    l = mid+1;
                }
            }else{
                // right sorted
                if(target > nums[mid] && target<= nums[r]){
                    l = mid+1;
                }
                else{
                    r = mid-1;
                }
            }

        }

        return -1;
        
    }
}
