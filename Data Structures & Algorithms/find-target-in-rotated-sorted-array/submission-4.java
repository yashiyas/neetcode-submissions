class Solution {
    public int search(int[] nums, int target) {
        int lower =0;
        int higher = nums.length - 1;

        while(lower >=0 && higher < nums.length && lower <= higher){
            int mid = lower + (higher-lower)/2;

            if(target == nums[mid]){
                return mid;
            }

            if(nums[mid] >= nums[lower]){
                if(target >= nums[lower] && target < nums[mid]){
                    higher = mid - 1;
                }else{
                    lower = mid +1;
                }
            } else{
                if(target > nums[mid] && target <= nums[higher]){
                    lower = mid + 1;
                } else{
                    higher = mid - 1;
                }
            }
        }

        return -1;
    }
}
