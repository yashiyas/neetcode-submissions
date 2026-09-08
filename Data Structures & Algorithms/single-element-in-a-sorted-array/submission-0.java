class Solution {
    public int singleNonDuplicate(int[] nums) {

        int n = nums.length;

        int l = 0;
        int r = nums.length-1;
        
        while(l<=r){
            int mid = (r-l)/2 + l;

            boolean isRightEqual = getIsEqual(mid,nums,mid+1);
            boolean isLeftEqual = getIsEqual(mid,nums,mid-1);

            if(!(isRightEqual || isLeftEqual )){
                return nums[mid];
            }

            if(isRightEqual){
                if((mid+1)%2 != 0){
                    l = mid+2;
                }else{
                    r = mid-1;
                }
            }else{
                if((mid)%2 != 0){
                    l = mid+1;
                }else{
                    r = mid-2;
                }
            }


        }

        return -1;
        
    }

    private boolean getIsEqual(int curr, int[] nums, int next){
        if(next < 0 || next >= nums.length){
            return false;
        }

        return nums[curr] == nums[next];
    }
}