class Solution {
    public List<List<Integer>> findMissingRanges(int[] nums, int lower, int upper) {

        List<List<Integer>> ans = new ArrayList();
        
        if(nums.length == 0){
            List<Integer> range = new ArrayList();
            range.add(lower);
            range.add(upper);
            ans.add(range);
            return ans;
        }

        

        if(nums[0] != lower){
            List<Integer> range = new ArrayList();
            range.add(lower);
            range.add(nums[0]-1);
            ans.add(range);
        }

        int prev = nums[0];

        for(int i=1; i<nums.length; i++){
            if(nums[i] != prev+1){
                List<Integer> range = new ArrayList();
                range.add(prev+1);
                range.add(nums[i]-1);
                ans.add(range);
            }
            prev = nums[i];
        }

        if(nums[nums.length-1] != upper){
            List<Integer> range = new ArrayList();
            range.add(nums[nums.length-1]+1);
            range.add(upper);
            ans.add(range);
        }

        return ans;
        
    }
}
