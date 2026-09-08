class Solution {
    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> ans = new ArrayList();
        List<Integer> curr = new ArrayList();

        helper(ans,curr,1,k,n);

        return ans;

        
    }

    private void helper(List<List<Integer>> ans, List<Integer> curr, int i, int k, int n){

        if(curr.size() == k){
            List<Integer> temp = new ArrayList<>(curr);
            ans.add(temp);
            return;
        }

        if(i>n){
            return;
        }

        for(int j=i; j<=n; j++){
            curr.add(j);
            helper(ans,curr,j+1,k,n);
            curr.remove(curr.size()-1);
        }



    }
}