class Solution {
    public List<List<Integer>> permute(int[] nums) {

        List<List<Integer>> permutations = new ArrayList();

        return compute(nums,0);
        
    }

    private List<List<Integer>> compute(int[] nums, int i){
        if(i==nums.length-1){
            List<List<Integer>> curr = new ArrayList();
            List<Integer> element = new ArrayList();
            element.add(nums[i]);
            curr.add(element);
            return curr;
        }

        List<List<Integer>> curr = new ArrayList();

        List<List<Integer>> next = compute(nums,i+1);

        int num = nums[i];

        for(List<Integer> perm: next){
            for(int j=0; j<perm.size();j++){
                List<Integer> copy = new ArrayList(perm);
                copy.add(j,num);
                curr.add(copy);
            }
            List<Integer> copy = new ArrayList(perm);
            copy.add(num);
            curr.add(copy);
        }

        return curr;
    }
}
