class Solution {
    public int findMin(int[] nums) {
        int ans = Integer.MAX_VALUE;

        int lower = 0;
        int higher = nums.length - 1;

        while(lower <= higher && lower>=0 && higher < nums.length){
            int mid = lower + (higher-lower)/ 2;
            if(nums[mid] >= nums[lower]){
                ans = Math.min(ans, nums[lower]);
                lower = mid+1;
            }
            else{
                ans = Math.min(ans, nums[mid]);
                higher = mid - 1;
            }
        }

        return ans;

    }
}
