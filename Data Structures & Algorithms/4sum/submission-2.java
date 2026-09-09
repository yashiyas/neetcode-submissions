class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        Set<List<Integer>> unique = new HashSet();


        Arrays.sort(nums);

        for(int i=0; i<nums.length; i++){
            //loop 1 (n)
           
            for(int j=i+1; j<nums.length; j++){
                // loop 2(n)
                long req = (long)target-(long)nums[i]-(long)nums[j];
                getTwoSum(nums, req, j+1, i, j , unique);
            }
        }

        List<List<Integer>> ans = new ArrayList();

        for(List<Integer> curr: unique){
            ans.add(curr);
        }

        return ans;
        
    }

    private void getTwoSum(int[] nums, long target, int start, int prev, int prev2, Set<List<Integer>> unique){
      
        int l = start;
        int r = nums.length-1;

        while(l<r){
            long currSum = (long)nums[l]+(long)nums[r];
            if(currSum == target){
                List<Integer> curr = new ArrayList();
                curr.add(nums[l]);
                curr.add(nums[r]);
                curr.add(nums[prev]);
                curr.add(nums[prev2]);
                Collections.sort(curr);
                unique.add(curr);
                l++;
                r--;
            }else if(currSum < target){
                l++;
            }else{
                r--;
            }
        }

    }
}