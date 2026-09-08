class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        Set<List<Integer>> ans = new HashSet();
        List<List<Integer>> res = new ArrayList();

        for(int i=0; i<nums.length; i++){
            Set<List<Integer>> curr = new HashSet<>();

            findPairs(nums,i, curr);
            for(List<Integer> l:curr){
                ans.add(l);
            }
        }
        for(List<Integer> l: ans){
            res.add(l);
        }
        return res;
    }

    void findPairs(int[] nums, int i, Set<List<Integer>> curr){
        int reqSum = nums[i] * -1;
        int j=i+1;
        int k=nums.length - 1;
        List<Integer> c = new ArrayList();

        while(j<k){
            if(j==i){
                j++;
                continue;
            }
            if(k==i){
                k--;
                continue;
            }
            int sum = nums[k] + nums[j];
            if(sum < reqSum){
                j++;
            }else if(sum > reqSum){
                k--;
            }
            else{
                c.add(nums[j]);
                c.add(nums[k]);
                c.add(nums[i]);
                Collections.sort(c);
                curr.add(c);
                j++;
                c = new ArrayList();
            }
        }
    }
}
