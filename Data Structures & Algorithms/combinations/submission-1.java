class Solution {
    public List<List<Integer>> combine(int n, int k) {

        List<List<Integer>> ans = new ArrayList();
        List<Integer> curr = new ArrayList();
        combineAlgo(ans, curr, 1, k, n);
        return ans;

        
    }

    private void combineAlgo(List<List<Integer>> ans, List<Integer> curr, int i, int k, int n){
        if(curr.size() == k){
            List<Integer> temp = new ArrayList(curr);
            ans.add(temp);
            return;
        }

        if(i > n){
            return;
        }

        curr.add(i);

        combineAlgo(ans, curr, i+1, k, n);

        curr.remove(curr.size() - 1);

        combineAlgo(ans, curr, i+1, k, n);

    }
}