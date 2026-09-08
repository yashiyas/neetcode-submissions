class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList();
        List<Integer> curr = new ArrayList();

        helper(0,ans,curr,nums);
        return ans;
        
    }

    private void helper(int i, List<List<Integer>> ans, List<Integer> curr, int[] nums){
        if(i >= nums.length){
            List<Integer> temp = new ArrayList();
            temp.addAll(curr);
            ans.add(temp);
            return;
        }

        //include
        curr.add(nums[i]);
        helper(i+1,ans,curr,nums);

        curr.remove(curr.size()-1);

        while(i+1<nums.length && nums[i] == nums[i+1]){
            i++;
        }
        helper(i+1,ans,curr,nums);

    }
}
