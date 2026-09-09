class Solution {
    public int missingElement(int[] nums, int k) {

        List<Integer> missed = new ArrayList();

        int prev = nums[0];

        for(int i=0; i<nums.length; i++){
            int missing = nums[i] - (nums[0]+i);
            missed.add(missing);
        }

        int index = getIndex(nums,k);

        int missing = nums[index] - (nums[0]+index);
        return nums[index]+(k-missing);
    
        
    }

    

    private int getIndex(int[] nums, int target){
        int index = 0;

        int l = 0;
        int r = nums.length - 1;

        while(l <=r ){
            int mid = (r-l)/2 + l;

            int missing = nums[mid] - (nums[0]+mid);

            if(missing < target){
                index = mid;
                l = mid+1;
            }else{
                r = mid-1;
            }
        }

        return index;
    }
}
