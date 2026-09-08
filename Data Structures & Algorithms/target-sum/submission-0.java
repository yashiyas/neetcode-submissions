class Solution {
    public int findTargetSumWays(int[] nums, int target) {

        List<List<Integer>> ways = new ArrayList();
        List<Integer> curr = new ArrayList();
        solve(nums,target,curr,0,ways);
        return ways.size();
        
    }

    private void solve(int[] nums, int target, List<Integer> curr, int index,List<List<Integer>> ways){
        if(index == nums.length){
            int sum=0;
            for(int i:curr){
                sum+=i;
            }
            if(target == sum){
                ArrayList<Integer> temp = new ArrayList(curr);
                ways.add(temp);
                return;
            }
            return;
        }
       //add
        curr.add(nums[index]);
        solve(nums,target,curr,index+1,ways);

        // subtract
        curr.remove(curr.size()-1);
        curr.add(-1*nums[index]);
        solve(nums,target,curr,index+1,ways);
        curr.remove(curr.size()-1);
    
    }
}
