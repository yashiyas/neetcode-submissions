class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList();
        List<Integer> curr = new ArrayList();
        int currSum = 0;

        combine(ans,candidates,target,curr, currSum, 0);

        return ans;
        
    }

    private void combine(List<List<Integer>> ans, int[] candidates, int target, List<Integer> curr, int currSum, int i){
        if(currSum == target){
            List<Integer> temp = new ArrayList(curr);
            ans.add(temp);
            return;
        }

        if(currSum > target){
            return;
        }

          if(i>=candidates.length){
            return;
        }

        // include i

        curr.add(candidates[i]);
        currSum+=candidates[i];
        combine(ans,candidates,target,curr,currSum,i+1);

        curr.remove(curr.size()-1);
        currSum-=candidates[i];

        int j = i;

        while(j<candidates.length-1 && candidates[j]==candidates[j+1]){
            j++;
        }

        combine(ans,candidates,target,curr,currSum,j+1);

    }
}
