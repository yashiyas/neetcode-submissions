class Solution {
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> ans = new ArrayList();

        List<Integer> curr = new ArrayList();

        helper(0,curr,ans,nums);

        return ans;
        
    }

    private void helper(int i, List<Integer> curr, List<List<Integer>> ans, int[] nums){
        if(i>=nums.length){
            List<Integer> temp = new ArrayList();
            temp.addAll(curr);
            ans.add(temp);
            return;
        }

        curr.add(nums[i]);
        helper(i+1,curr,ans,nums);

        curr.remove(curr.size()-1);
        helper(i+1,curr,ans,nums);
    }
}
