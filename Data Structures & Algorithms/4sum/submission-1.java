class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        Set<List<Integer>> unique = new HashSet();


        Arrays.sort(nums);

        for(int i=0; i<nums.length; i++){
            long req = (long)target-(long)nums[i];
            for(int j=i+1; j<nums.length; j++){
                findTreesome(nums, j, req , i, unique);
            }
        }

        List<List<Integer>> ans = new ArrayList();

        for(List<Integer> curr: unique){
            ans.add(curr);
        }

        return ans;
        
    }

    private void findTreesome(int[] nums, int start, long target, int prev, Set<List<Integer>> unique){
        for(int i=start; i<nums.length; i++){
            long currTar = target-(long)nums[i];
            

            List<List<Integer>> twoSums = getTwoSum(nums,currTar,i+1);

            if(!twoSums.isEmpty()){
                for(List<Integer> twoSum: twoSums){
                     List<Integer> currFoursome = new ArrayList();
                    currFoursome.add(nums[prev]);
                    currFoursome.add(nums[i]);
                    currFoursome.add(twoSum.get(0));
                    currFoursome.add(twoSum.get(1));

                    Collections.sort(currFoursome);
                    unique.add(currFoursome);

                }
            }

        }
    }

    private List<List<Integer>> getTwoSum(int[] nums, long target, int start){
        List<List<Integer>> ans = new ArrayList();
        int l = start;
        int r = nums.length-1;

        while(l<r){
            long currSum = (long)nums[l]+(long)nums[r];
            if(currSum == target){
                List<Integer> curr = new ArrayList();
                curr.add(nums[l]);
                curr.add(nums[r]);
                ans.add(curr);
                l++;
                r--;
            }else if(currSum < target){
                l++;
            }else{
                r--;
            }
        }

        return ans;
    }
}